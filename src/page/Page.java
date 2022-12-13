package page;

import admin.PageHandler;
import input.ActionsInput;

import java.util.ArrayList;

public abstract class Page {
    private ArrayList<Page> subPages;
    private String name;

    public Page(final String name) {
        subPages = new ArrayList<>();
        this.name = name;
    }

    /**
     *
     * @param namePage
     * @return
     */
    public Page changePage(final String namePage) {
        for (var page: subPages) {
            if (page.getName().equals(namePage)) {
                return page;
            }
        }
        return null;
    }

    /**
     *
     * @param action
     * @param pageHandler
     * @return
     */
    public abstract String onPage(ActionsInput action, PageHandler pageHandler);

    /**
     *
     * @param action
     * @param pageHandler
     */
    public abstract void getMovies(ActionsInput action, PageHandler pageHandler);
    public final ArrayList<Page> getSubPages() {
        return subPages;
    }

    public final void setSubPages(final ArrayList<Page> subPages) {
        this.subPages = subPages;
    }

    public final String getName() {
        return name;
    }

    public final void setName(final String name) {
        this.name = name;
    }

}
