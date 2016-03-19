package me.sharma.vardan.healtyfy.data;

import retrofit.http.GET;
import rx.Observable;

public interface HealthyFyService {
    @GET("events/upcoming/?format=json")
    Observable<EventsListWrapper> getEvents();
}