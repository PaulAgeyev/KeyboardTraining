package DAO;

import Domain.Progress;

import java.util.ArrayList;

/**
 * Created by Nikitos on 06.07.2016.
 */
public interface ProgressDAO {

    void insertProgress(Progress progress);
    boolean updateProgress(Progress progress);
    boolean deleteProgress(Progress progress);


}
