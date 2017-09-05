package rest;

import rx.Observable;

/**
 * Created by GoFundMe on 1/11/17.
 */

public interface ITemplateApiService {
    Observable<Object> getSomePathAsync(final String token);

}
