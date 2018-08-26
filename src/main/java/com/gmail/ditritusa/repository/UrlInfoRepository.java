package com.gmail.ditritusa.repository;

import com.gmail.ditritusa.model.UrlInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlInfoRepository extends JpaRepository<UrlInfo, Long> {
}
