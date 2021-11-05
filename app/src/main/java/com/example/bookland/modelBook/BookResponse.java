
package com.example.bookland.modelBook;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BookResponse {

    @SerializedName("query")
    @Expose
    private String query;
    @SerializedName("results-start")
    @Expose
    private String resultsStart;
    @SerializedName("results-end")
    @Expose
    private String resultsEnd;
    @SerializedName("total-results")
    @Expose
    private String totalResults;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("query-time-seconds")
    @Expose
    private String queryTimeSeconds;
    @SerializedName("results")
    @Expose
    private List<Result> results = null;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getResultsStart() {
        return resultsStart;
    }

    public void setResultsStart(String resultsStart) {
        this.resultsStart = resultsStart;
    }

    public String getResultsEnd() {
        return resultsEnd;
    }

    public void setResultsEnd(String resultsEnd) {
        this.resultsEnd = resultsEnd;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getQueryTimeSeconds() {
        return queryTimeSeconds;
    }

    public void setQueryTimeSeconds(String queryTimeSeconds) {
        this.queryTimeSeconds = queryTimeSeconds;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

}
