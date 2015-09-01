package com.einmalfel.earl;

import android.support.annotation.NonNull;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.net.URL;

public class RSSSource {
  static final String XML_TAG = "source";

  public final String value;
  public final URL url;

  @NonNull
  static RSSSource read(@NonNull XmlPullParser parser) throws IOException, XmlPullParserException {
    parser.require(XmlPullParser.START_TAG, XmlPullParser.NO_NAMESPACE, XML_TAG);
    String url = parser.getAttributeValue(XmlPullParser.NO_NAMESPACE, "url");
    return new RSSSource(parser.nextText(), url == null ? null : new URL(url));
  }

  public RSSSource(String value, URL url) {
    this.value = value;
    this.url = url;
  }
}