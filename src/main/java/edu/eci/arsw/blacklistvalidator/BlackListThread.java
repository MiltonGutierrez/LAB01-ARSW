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
    private int ocurrencesCount;
    private int checkedListsCount;
    private String ipAddress;
    private LinkedList<Integer> blackListOcurrences=new LinkedList<>();
    @Override
    public void run() {
        HostBlacklistsDataSourceFacade skds=HostBlacklistsDataSourceFacade.getInstance();
        for (int i = this.start ; i <= this.end && ocurrencesCount<BLACK_LIST_ALARM_COUNT ;i++){
        
            this.checkedListsCount++; 

            if (skds.isInBlackListServer(i, ipAddress)){
                
                blackListOcurrences.add(i);
                
                this.ocurrencesCount++;
            }
        }
    }    

    //LOG.log(Level.INFO, "Checked Black Lists:{0} of {1}", new Object[]{checkedListsCount, skds.getRegisteredServersCount()});
    public BlackListThread(int start, int end, String ipAddress){
        this.start = start;
        this.end = end;
        this.ipAddress = ipAddress;
        this.ocurrencesCount = 0;
        this.checkedListsCount = 0;
    }
    
    public int getCheckedLists() {
        return this.checkedListsCount;
    }
    
    public int getOcurrencesCount() {
        return this.ocurrencesCount;
    }

    public LinkedList<Integer> getBlackListOcurrences(){
        return this.blackListOcurrences;
    }
}


    
