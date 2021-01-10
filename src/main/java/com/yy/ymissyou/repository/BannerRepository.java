package com.yy.ymissyou.repository;

import com.yy.ymissyou.model.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerRepository extends JpaRepository<Banner,Long> {
    /**
     * 通过id查Banner
     */
    Banner findOneById(Long id);

    /**
     * 通过name查找Banner
     */
    Banner findOneByName(String name);
}
