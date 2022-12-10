package input;

import java.util.ArrayList;
public class FiltersInput {
    private Contains contains;
    private Sort sort;

    public Contains getContains() {
        return contains;
    }

    public void setContains(Contains contains) {
        this.contains = contains;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "FiltersInput{" +
                "contains=" + contains +
                ", sort=" + sort +
                '}';
    }
}
