package edu.eci.arsw.blacklistvalidator;
import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BlackListThread extends Thread{
    private static final int BLACK_LIST_ALARM_COUNT=5; //direccion registrada 5 veces
    private int start;
    private int end;
    private String ipaddress;
    private int ocurrencesCount = 0;
    private int checkedListsCount = 0;
    private LinkedList<Integer> blackListOcurrences=new LinkedList<>();
    HostBlacklistsDataSourceFacade skds=HostBlacklistsDataSourceFacade.getInstance();
    @Override

    public void run() {
        for (int i = this.start ; i < this.end && ocurrencesCount<BLACK_LIST_ALARM_COUNT ;i++){
            checkedListsCount++;
            // if (){
                blackListOcurrences.add(i);
                this.ocurrencesCount++;
                System.out.println(ocurrencesCount);
             }
        }    

        //LOG.log(Level.INFO, "Checked Black Lists:{0} of {1}", new Object[]{checkedListsCount, skds.getRegisteredServersCount()});
        public BlackListThread(int start, int end, String ipaddress){
            this.start = start;
            this.end = end;
            this.ipaddress = ipaddress;
            this.ocurrencesCount = 0;
            this.checkedListsCount = 0;
        }
    
        public int getCheckedLists() {
            return checkedListsCount;
        }
    
        public int getOcurrencesCount() {
            return ocurrencesCount;
        }
    }


    
