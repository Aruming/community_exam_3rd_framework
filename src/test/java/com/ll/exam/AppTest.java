package com.ll.exam;

import com.ll.exam.controller.ArticleController;
import com.ll.exam.controller.HomeController;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
    @Test
    public void junit_assertThat() {
        int rs = 10 + 20;

        assertThat(rs).isEqualTo(30);
    }

    @Test
    public void ioc__articleController() {
        ArticleController articleController = Container.getArticleController();

        assertThat(articleController).isNotNull();
    }

    @Test
    public void ioc__articleController__singleton() {
        ArticleController articleController1 = Container.getArticleController();
        ArticleController articleController2 = Container.getArticleController();

        assertThat(articleController2).isEqualTo(articleController1);
    }

    @Test
    public void ioc__homeController() {
        HomeController homeController = Container.getHomeController();

        assertThat(homeController).isNotNull();
    }

    @Test
    public void ioc__homeController__singleton() {
        HomeController homeController1 = Container.getHomeController();
        HomeController homeController2 = Container.getHomeController();

        assertThat(homeController2).isEqualTo(homeController1);
    }

    @Test
    public void ioc__Controller들을_스캔하여_수집() {
        List<String> names = Container.getControllerNames();

        assertThat(names).contains("home");
        assertThat(names).contains("article");
    }
}
