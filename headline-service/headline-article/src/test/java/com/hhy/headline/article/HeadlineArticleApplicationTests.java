package com.hhy.headline.article;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hhy.headline.article.mapper.ApArticleContentMapper;

import com.hhy.headline.article.mapper.ApArticleMapper;
import com.hhy.headline.article.service.ApArticleService;
import com.hhy.headline.file.service.FileStorageService;
import com.hhy.headline.model.article.pojos.ApArticle;
import com.hhy.headline.model.article.pojos.ApArticleContent;
import freemarker.template.Template;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import freemarker.template.Configuration;
import org.springframework.test.context.junit4.SpringRunner;
import org.apache.commons.lang3.StringUtils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest(classes = HeadlineArticleApplication.class)
@RunWith(SpringRunner.class)
class HeadlineArticleApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    private Configuration configuration;

    @Autowired
    private FileStorageService fileStorageService;


    @Autowired
    private ApArticleMapper apArticleMapper;
    @Autowired
    public ApArticleContentMapper apArticleContentMapper;

    @Autowired
    public ApArticleService apArticleService;
    @Test
    public void createStaticUrlTest() throws Exception {
        // 1. 获取文章内容
        ApArticleContent apArticleContent = apArticleContentMapper
                .selectOne(Wrappers.<ApArticleContent>lambdaQuery().eq(ApArticleContent::getArticleId, 1383827787629252610l));
        if(apArticleContent != null && StringUtils.isNotBlank(apArticleContent.getContent())){
            //2.文章内容通过freemarker生成html文件
            StringWriter out = new StringWriter();
            Template template = configuration.getTemplate("article.ftl");

            Map<String, Object> params = new HashMap<>();
            params.put("content", JSONArray.parseArray(apArticleContent.getContent()));

            template.process(params, out);
            InputStream is = new ByteArrayInputStream(out.toString().getBytes());

            //3.把html文件上传到minio中
            String path = fileStorageService.uploadHtmlFile("", apArticleContent.getArticleId() + ".html", is);

            //4.修改ap_article表，保存static_url字段
            ApArticle article = new ApArticle();
            article.setId(apArticleContent.getArticleId());
            article.setStaticUrl(path);
            apArticleMapper.updateById(article);
//            apArticleService
//                    .update(Wrappers.<ApArticle>lambdaUpdate().eq(ApArticle::getId, apArticleContent.getArticleId())
//                    .set(ApArticle::getStaticUrl, path));
        }
    }
}
