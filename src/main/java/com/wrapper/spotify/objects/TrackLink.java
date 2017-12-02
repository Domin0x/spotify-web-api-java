package com.wrapper.spotify.objects;

import net.sf.json.JSONObject;

public class TrackLink extends AbstractModelObject {
  private final ExternalUrls externalUrls;
  private final String href;
  private final String id;
  private final ObjectType type;
  private final String uri;

  private TrackLink(final TrackLink.Builder builder) {
    super(builder);

    this.externalUrls = builder.externalUrls;
    this.href = builder.href;
    this.id = builder.id;
    this.type = builder.type;
    this.uri = builder.uri;
  }

  public ExternalUrls getExternalUrls() {
    return externalUrls;
  }

  public String getHref() {
    return href;
  }

  public String getId() {
    return id;
  }

  public ObjectType getType() {
    return type;
  }

  public String getUri() {
    return uri;
  }

  @Override
  public Builder builder() {
    return new Builder();
  }

  public static final class Builder extends AbstractModelObject.Builder {
    private ExternalUrls externalUrls;
    private String href;
    private String id;
    private ObjectType type;
    private String uri;

    public Builder setExternalUrls(ExternalUrls externalUrls) {
      this.externalUrls = externalUrls;
      return this;
    }

    public Builder setHref(String href) {
      this.href = href;
      return this;
    }

    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    public Builder setType(ObjectType type) {
      this.type = type;
      return this;
    }

    public Builder setUri(String uri) {
      this.uri = uri;
      return this;
    }

    @Override
    public TrackLink build() {
      return new TrackLink(this);
    }
  }

  public static final class JsonUtil extends AbstractModelObject.JsonUtil<TrackLink> {
    public TrackLink createModelObject(JSONObject jsonObject) {
      if (jsonObject == null || jsonObject.isNullObject()) {
        return null;
      }

      return new TrackLink.Builder()
              .setExternalUrls(new ExternalUrls.JsonUtil().createModelObject(jsonObject.getJSONObject("external_urls")))
              .setHref(jsonObject.getString("href"))
              .setId(jsonObject.getString("id"))
              .setType(ObjectType.valueOf(jsonObject.getString("type")))
              .setUri(jsonObject.getString("uri"))
              .build();
    }
  }
}
