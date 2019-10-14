package com.tws.refactoring.extract_variable;

import com.tws.refactoring.extract_variable.BannerRender;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BannerRenderTest {
    @Test
    public void macOnIE() {
        //given
        BannerRender bannerRender = new BannerRender();
        //when
        String banner = bannerRender.renderBanner("MAC", "IE");
        //then
        assertThat(banner, is("IE on Mac?"));
    }

    @Test
    public void macOnFirefox() {
        //given
        BannerRender bannerRender = new BannerRender();
        //when
        String banner = bannerRender.renderBanner("MAC", "Firefox");
        //then
        assertThat(banner, is("banner"));
    }

    @Test
    public void windowsOnIE() {
        //given
        BannerRender bannerRender = new BannerRender();
        //when
        String banner = bannerRender.renderBanner("Windows", "Firefox");
        //then
        assertThat(banner, is("banner"));
    }
}
