package com.hqyj.dao;

import com.hqyj.entity.Course;

public interface CourseMapper {
    int deleteByPrimaryKey(Integer courseId);

    Course selectByPrimaryKey(Integer courseId);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
}