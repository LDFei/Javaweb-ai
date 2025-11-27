package org.example.tliaswebmanagement.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T>{
    private Long total;
    private List<T> rows;
    //全参构造和无参构造
//    public PageResult() {
//    }
//
//    public PageResult(Long total, List<T> rows) {
//        this.total = total;
//        this.rows = rows;
//    }
//    /**
//     * 获取
//     * @return total
//     */
//    public Long getTotal() {
//        return total;
//    }
//
//    /**
//     * 设置
//     * @param total
//     */
//    public void setTotal(Long total) {
//        this.total = total;
//    }
//
//    /**
//     * 获取
//     * @return rows
//     */
//    public List<T> getRows() {
//        return rows;
//    }
//
//    /**
//     * 设置
//     * @param rows
//     */
//    public void setRows(List<T> rows) {
//        this.rows = rows;
//    }
//
//    public String toString() {
//        return "PageResult{total = " + total + ", rows = " + rows + "}";
//    }
}
