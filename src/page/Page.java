package page;

import admin.PageHandler;
import input.ActionsInput;
import user.User;

import java.util.ArrayList;

public abstract class Page {
    private ArrayList<Page> subPages;
    private String name;

    public Page(String name){
        subPages = new ArrayList<>();
        this.name = name;
    }

    public Page changePage(String name) {
        for (var page: subPages) {
            if (page.getName().equals(name))
                return page;
        }
        return null;
    }

    public abstract String onPage(ActionsInput action, PageHandler pageHandler);
    public ArrayList<Page> getSubPages() {
        return subPages;
    }

    public void setSubPages(ArrayList<Page> subPages) {
        this.subPages = subPages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
