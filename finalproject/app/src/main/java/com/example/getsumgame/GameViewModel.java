package com.example.getsumgame;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.getsumgame.data.GameInfo;
import com.example.getsumgame.data.GameListItem;
import com.example.getsumgame.data.Status;
import com.example.getsumgame.data.gameRepository;

import java.sql.ClientInfoStatus;
import java.util.List;

public class GameViewModel extends ViewModel {
    private gameRepository mRepo;
    private LiveData<List<GameInfo>> mGameInfo;
//    private LiveData<List<GameListItem>> mGameResult;
    private LiveData<Status> mLoadingStatus;


    public GameViewModel(){
        mRepo=new gameRepository();
//        mGameResult=mRepo.getmGameResult();
        mGameInfo=mRepo.getmGameInfo();
        mLoadingStatus=mRepo.getmLoadingStatus();
    }

    public void loadGameResults(String CLIENT_ID,String Get_Top_Game){
        mRepo.loadGameResults(CLIENT_ID,Get_Top_Game);
    }

    public LiveData<Status> getmLoadingStatus() {
        return mLoadingStatus;
    }

    public LiveData<List<GameInfo>> getmGameInfo() {
        return mGameInfo;
    }
    //    public LiveData<List<GameListItem>> getmGameResult() {
//        return mGameResult;
//    }


}

