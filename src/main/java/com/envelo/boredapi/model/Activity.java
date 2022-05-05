package com.envelo.boredapi.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "activity",
        "type",
        "participants",
        "price",
        "link",
        "key",
        "accessibility"
})
@Generated("jsonschema2pojo")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Activity {

    @JsonProperty("activity")
    private String activity;
    @JsonProperty("type")
    private String type;
    @JsonProperty("participants")
    private Integer participants;
    @JsonProperty("price")
    private Integer price;
    @JsonProperty("link")
    private String link;
    @JsonProperty("key")
    private String key;
    @JsonProperty("accessibility")
    private Double accessibility;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("activity")
    public String getActivity() {
        return activity;
    }

    @JsonProperty("activity")
    public void setActivity(String activity) {
        this.activity = activity;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("participants")
    public Integer getParticipants() {
        return participants;
    }

    @JsonProperty("participants")
    public void setParticipants(Integer participants) {
        this.participants = participants;
    }

    @JsonProperty("price")
    public Integer getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Integer price) {
        this.price = price;
    }

    @JsonProperty("link")
    public String getLink() {
        return link;
    }

    @JsonProperty("link")
    public void setLink(String link) {
        this.link = link;
    }

    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

    @JsonProperty("accessibility")
    public Double getAccessibility() {
        return accessibility;
    }

    @JsonProperty("accessibility")
    public void setAccessibility(Double accessibility) {
        this.accessibility = accessibility;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
