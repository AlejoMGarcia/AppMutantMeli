package app.meli.mutant.util;

import org.springframework.stereotype.Component;

@Component
public class SequenceUtils {

    public boolean checkSequenceHorizontally(String[] sequence, int indexRow, int indexColumn){
        boolean check = false;

        if(checkHorizontal(sequence, indexRow, indexColumn)){
            if(checkLeft(sequence, indexRow, indexColumn)
                    || checkRigth(sequence, indexRow, indexColumn)){
                check = true;
            }
        }
        return check;
    }

    public boolean checkSequenceVertically(String[] sequence, int indexRow, int indexColumn) {
        boolean check = false;

        if(checkVertical(sequence, indexRow, indexColumn)){
            if(checkUp(sequence, indexRow, indexColumn)
                    || checkDown(sequence, indexRow, indexColumn)){
                check = true;
            }
        }
        return check;
    }

    public boolean countSequenceObliqueLeftRight(String[] sequence, int indexRow, int indexColumn) {
        boolean check = false;

        if(checkObliqueLeftRightChars(sequence, indexRow, indexColumn)){
            if(checkObliqueUpRigth(sequence, indexRow, indexColumn)
                    || checkObliqueDownLeft(sequence, indexRow, indexColumn)){
                check = true;
            }
        }
        return check;
    }

    public boolean countSequenceObliqueRightLeft(String[] sequence, int indexRow, int indexColumn) {
        boolean check = false;

        if(checkObliqueRightLeftChars(sequence, indexRow, indexColumn)){
            if(checkObliqueUpLeft(sequence, indexRow, indexColumn)
                    || checkObliqueDownRight(sequence, indexRow, indexColumn)){
                check = true;
            }
        }
        return check;
    }

    public boolean checkObliqueLeftRightChars(String[] sequence, int indexRow, int indexColumn) {
        return (checkChars(sequence, indexRow, -1, indexColumn, 1)
                || (checkChars(sequence, indexRow, 1, indexColumn, -1)));
    }

    public boolean checkObliqueUpRigth(String[] sequence, int indexRow, int indexColumn) {
        return (checkChars(sequence, indexRow, -1, indexColumn, 1)
                && checkChars(sequence, indexRow, -2, indexColumn, 2)
                && checkChars(sequence, indexRow, -3, indexColumn, 3));
    }

    public boolean checkObliqueDownLeft(String[] sequence, int indexRow, int indexColumn) {
        return (checkChars(sequence, indexRow, 1, indexColumn, -1)
                && checkChars(sequence, indexRow, 2, indexColumn, -2)
                && (checkChars(sequence, indexRow, 3, indexColumn, -3)
                || checkChars(sequence, indexRow, -1, indexColumn, 1)));
    }

    public boolean checkObliqueRightLeftChars(String[] sequence, int indexRow, int indexColumn) {
        return (checkChars(sequence, indexRow, -1, indexColumn, -1)
                || (checkChars(sequence, indexRow, 1, indexColumn, 1)));
    }

    public boolean checkObliqueUpLeft(String[] sequence, int indexRow, int indexColumn) {
        return (checkChars(sequence, indexRow, -1, indexColumn, -1)
                && checkChars(sequence, indexRow, -2, indexColumn, -2)
                && (checkChars(sequence, indexRow, -3, indexColumn, -3)
                || checkChars(sequence, indexRow, 1, indexColumn, 1)));
    }

    public boolean checkObliqueDownRight(String[] sequence, int indexRow, int indexColumn) {
        return (checkChars(sequence, indexRow, 1, indexColumn, 1)
                && checkChars(sequence, indexRow, 2, indexColumn, 2)
                && (checkChars(sequence, indexRow, 3, indexColumn, 3)
                || checkChars(sequence, indexRow, -1, indexColumn, -1)));
    }

    public boolean checkHorizontal(String[] sequence, int indexRow, int indexColumn) {
        return (checkChars(sequence, indexRow, 0, indexColumn, -1)
                || checkChars(sequence, indexRow, 0, indexColumn, 1));
    }

    public boolean checkLeft(String[] sequence, int indexRow, int indexColumn){
        return (checkChars(sequence, indexRow, 0, indexColumn, -1)
                && checkChars(sequence, indexRow, 0, indexColumn, -2)
                && (checkChars(sequence, indexRow, 0, indexColumn, -3)
                || checkChars(sequence, indexRow, 0, indexColumn, 1)));
    }

    public boolean checkRigth(String[] sequence, int indexRow, int indexColumn){
        return (checkChars(sequence, indexRow, 0, indexColumn, 1)
                && checkChars(sequence, indexRow, 0, indexColumn, 2)
                && (checkChars(sequence, indexRow, 0, indexColumn, 3)
                || checkChars(sequence, indexRow, 0, indexColumn, -1)));
    }

    public boolean checkVertical(String[] sequence, int indexRow, int indexColumn) {
        return (checkChars(sequence, indexRow, -1, indexColumn, 0)
                || checkChars(sequence, indexRow, 1, indexColumn, 0));
    }

    public boolean checkUp(String[] sequence, int indexRow, int indexColumn){
        return (checkChars(sequence, indexRow, -1, indexColumn, 0)
                && checkChars(sequence, indexRow, -2, indexColumn, 0)
                && (checkChars(sequence, indexRow, -3, indexColumn, 0)
        )          || checkChars(sequence, indexRow, 1, indexColumn, 0));
    }

    public boolean checkDown(String[] sequence, int indexRow, int indexColumn){
        return (checkChars(sequence, indexRow,1, indexColumn, 0)
                && checkChars(sequence, indexRow,2, indexColumn, 0)
                && (checkChars(sequence, indexRow, 3, indexColumn,0)
                || checkChars(sequence, indexRow, -1, indexColumn,0)));
    }

    private boolean checkChars(String[] sequence, int n, int addToN, int i, int addToI) {
        return ( 0 <= n+addToN
                && n+addToN + 1 <= sequence.length
                && sequence[n].length() >= i + 1
                && sequence[n+addToN].length() >= i+addToI + 1
                && sequence[n].charAt(i) == sequence[n+addToN].charAt(i+addToI));
    }

}
