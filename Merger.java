/**
  Represent a merge operation for sorted lists,
  as described in README.md
 */
import java.util.ArrayList;

public class Merger {

    ArrayList<String> usersData;

    /**
      Construct an instance from a list of data
      part of which is to be merged. See README
     */
    public Merger( ArrayList<String> list) {
        usersData = list;
    }


    /**
      Merge the sorted sub-lists.
     */
    public void merge(
      // indexes of sub-list boundaries; see README
        int start0  // index of first item in list0
      , int start1  // index of first item in list1
                    // = just past end of list0
      , int nItems  // number of items in the merged list
                    // = just past end of list1
      ) {
		 ArrayList<String> sortedList = new ArrayList<String>();
		 int counter0 = 0, counter1 = 0;
		 while (counter0 + counter1 < nItems - start0){
			 if (counter0 + start0>= start1 || usersData.get(counter0+start0).compareTo(usersData.get(counter1+start1)) >= 0){
				 sortedList.add(counter0+counter1,usersData.get(counter1+start1));
				 counter1+=1;
			 }
			 else {
				 sortedList.add(counter0+counter1, usersData.get(counter0+start0));
				 counter0+=1;
			 }
		 }
		 usersData = sortedList;
    }


    /**
      @return a string representation of the user's data
     */
    public String toString() {
        return "" + usersData; 
    }

    
    /** 
      @return the boolean value of the statement
         "the data in the range are in ascending order"
     */
    public boolean isSorted( int startAt, int endBefore) {
        for( int i = startAt
           ; i < endBefore -1 // stop early, because comparing to next
           ; i++
           )
            if( usersData.get(i).compareTo( usersData.get(i+1)) > 0) return false;
        return true;
    }
}