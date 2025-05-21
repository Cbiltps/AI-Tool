const axios = require('axios');
const cheerio = require('cheerio');
const fs = require('fs-extra');
const path = require('path');

async function scrapeTags(url, className) {
    try {
        // 发送 HTTP 请求获取网页内容
        const { data } = await axios.get(url);
        // 使用 cheerio 解析 HTML
        const $ = cheerio.load(data);

        // 准备存储数据的数组
        const items = [];

        // 使用 for...of 循环处理异步操作
        const elements = $(`.${className}`).children();
        for (const element of elements) {
            const obj = {};
            // 获取title
            const title = $(element).find('.group_desc___gXe8I').text().trim();
            obj.title = title;
            obj.list = [];

            const groupArea = $(element).find('.group_area___nWXY5');
            const aTags = groupArea.children();

            // 处理每个a标签
            for (const aTag of aTags) {
                const hTitle = $(aTag).find('.name___K96iv').text().trim();
                const text = $(aTag).find('.desc___uotr7').text().trim();
                const href = $(aTag).attr('href');

                // 创建一个对象来存储每个项目的数据
                const item = {
                    h_title: hTitle,
                    text: text,
                    url: href,
                };

                // 获取图片url
                const imgTag = $(aTag).find('img');
                let imgSrc = imgTag.attr('src');
                if (imgSrc && !imgSrc.startsWith('http')) {
                    // 如果是相对路径，转换为绝对路径
                    imgSrc = new URL(imgSrc, url).href;
                }

                if (imgSrc) {
                    try {
                        // 下载图片
                        const imgResponse = await axios.get(imgSrc, { responseType: 'arraybuffer' });
                        const imgName = path.basename(imgSrc);
                        const imgPath = path.join(__dirname, 'iconsimage', imgName);

                        // 确保图片文件夹存在
                        await fs.ensureDir(path.join(__dirname, 'iconsimage'));

                        // 保存图片
                        await fs.writeFile(imgPath, imgResponse.data);

                        // 添加图片相对路径到item对象
                        item.imageurl = `./iconsimage/${imgName}`;
                    } catch (imgError) {
                        console.error(`图片下载失败: ${imgError}`);
                    }
                }

                // 将项目数据添加到数组中
                obj.list.push(item);
            }

            items.push(obj);
        }

        // 将数据写入json文件
        const jsonPath = path.join(__dirname, 'output.json');
        await fs.writeJson(jsonPath, items);

        console.log('抓取和下载完成', items);
        return items;
    } catch (error) {
        console.error(`错误: ${error}`);
        throw error;
    }
}

// 使用示例
const url = 'https://www.cda.cn/aitools.html';
const className = 'main_wrapper___Yfmbq';
scrapeTags(url, className).catch(console.error);
