package rest;

import retrofit2.Response;

/**
 * Created by GoFundMe on 1/11/17.
 */
public interface IErrorHandlingService {
    <T> T filterResponseForErrors(Response<T> response);
}
