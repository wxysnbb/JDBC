package wd.util;

//简单的分页工具
public class PageUtil {
    private int pageIndex;  //当前页
    private int pageSize=2;   //页大小
    private int pageCount;  //页总数
    private int totalCount; //总记录数



    /**
     * 因为我们已经确定了 页大小
     * 在我们知道了总记录数后，我们可以确定总页数
     */
    public void setTotalCount(int totalCount) {
        if(totalCount>0){
            this.totalCount=totalCount;//获取总记录数
            //总页数=（总记录数%页大小==0）？（总记录数/页大小）:（总记录数/页大小+1
            this.pageCount=(totalCount%pageSize==0)?(totalCount/pageSize):(totalCount/pageSize+1);
        }

        this.totalCount = totalCount;
    }
    public int getTotalCount() {
        return totalCount;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public PageUtil(int pageIndex, int pageSize, int pageCount, int totalCount) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.pageCount = pageCount;
        this.totalCount = totalCount;
    }
}
