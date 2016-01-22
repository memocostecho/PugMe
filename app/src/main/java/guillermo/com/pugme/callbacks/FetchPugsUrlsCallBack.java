package guillermo.com.pugme.callbacks;

import java.util.List;

/**
 * Created by guillermo.rosales on 21/01/16.
 */
public interface FetchPugsUrlsCallBack {

    void onPugsUrlsFetched(List<String> urls);

    void onReportsFetchFailed(String message);
}
