package de.scandio.fifa.planner.comparator;

import de.scandio.fifa.planner.model.TableItem;

import java.util.Comparator;

/**
 * A comparator for comparing {@link TableItem}s. Is used to sort the table of a league.
 *
 * Created by stefanmuecke on 20.10.16.
 */
public class TableComparator implements Comparator<TableItem> {

    /**
     * A method to compare two {@link TableItem}s. If the points of both {@link TableItem}s are equal, a comparison
     * of the goal difference is done.
     *
     * @param o1 a {@link TableItem}
     * @param o2 a {@link TableItem}
     * @return an integer
     */
    @Override
    public int compare(TableItem o1, TableItem o2) {
        Integer p1 = o1.getPoints();
        Integer p2 = o2.getPoints();
        Integer p3 = o1.getDiff();
        Integer p4 = o2.getDiff();

        if (p1 > p2) {
            return 1;
        } else if (p1 < p2){
            return -1;
        } else {
            if (p3 > p4) {
                return 1;
            } else if (p3 < p4){
                return -1;
            } else {
                return 0;
            }
        }
    }

}
