package com.javaee.ex11.mapper;

import com.javaee.ex11.po.ApplyBook;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ApplyBookMapper {
    int findApplyCountByBookId(int bookId);
    ApplyBook findApplyBookByApplyBookId(int applyBookId);
    List<ApplyBook> findApplyBooksByUserId(int userId);
    List<ApplyBook> findNoApprovedApplyBooks(); // 查询未审批的申请
    List<ApplyBook> findApprovedApplyBooks();   // 查询已通过审批的申请
    List<ApplyBook> findApplyBooksInStorage();
    int editApplyBookStatus(ApplyBook applyBook);
    int editApplyBook(ApplyBook applyBook);
    int editApplyCount(ApplyBook applyBook);

    int addApplyBook(ApplyBook applyBook);
    int approveApply(ApplyBook applyBook);
}
