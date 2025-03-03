package com.javaee.ex03.mapper;

import com.javaee.ex03.po.Publisher;

public interface PublisherMapper {
    Publisher findPublisherByPubId(int pubId);
    Publisher findPublisherByPubIdEx(int pubId);
}
