package com.cvs.provider;

import com.google.common.collect.ImmutableList;

import java.util.List;

public class SimpleProfileProvider implements IProfileProvider {

    public List<String> getProfileUrls() {
        return ImmutableList.of(
                "https://www.linkedin.com/in/ghaicharanjit/",
                "https://www.linkedin.com/in/chaitanyasarda/",
                "https://www.linkedin.com/in/vpoddar07"
        );
    }
}
