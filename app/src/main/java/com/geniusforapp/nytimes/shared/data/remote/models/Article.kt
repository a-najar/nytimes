package com.geniusforapp.nytimes.shared.data.remote.models


import com.google.gson.annotations.SerializedName

data class Article(
        @SerializedName("abstract")
        val `abstract`: String,
        @SerializedName("adx_keywords")
        val adxKeywords: String,
        @SerializedName("asset_id")
        val assetId: Long,
        @SerializedName("byline")
        val byline: String,
        @SerializedName("column")
        val column: Any,
        @SerializedName("des_facet")
        val desFacet: Any,
        @SerializedName("geo_facet")
        val geoFacet: Any,
        @SerializedName("id")
        val id: Long,
        @SerializedName("media")
        val media: List<Media>,
        @SerializedName("org_facet")
        val orgFacet: Any,
        @SerializedName("per_facet")
        val perFacet: Any,
        @SerializedName("published_date")
        val publishedDate: String,
        @SerializedName("section")
        val section: String,
        @SerializedName("source")
        val source: String,
        @SerializedName("title")
        val title: String,
        @SerializedName("type")
        val type: String,
        @SerializedName("uri")
        val uri: String,
        @SerializedName("url")
        val url: String,
        @SerializedName("views")
        val views: Int
) {
    data class Media(
            @SerializedName("approved_for_syndication")
            val approvedForSyndication: Int,
            @SerializedName("caption")
            val caption: String,
            @SerializedName("copyright")
            val copyright: String,
            @SerializedName("media-metadata")
            val mediaMetadata: List<MediaMetadata>,
            @SerializedName("subtype")
            val subtype: String,
            @SerializedName("type")
            val type: String
    ) {
        data class MediaMetadata(
                @SerializedName("format")
                val format: String,
                @SerializedName("height")
                val height: Int,
                @SerializedName("url")
                val url: String,
                @SerializedName("width")
                val width: Int
        )
    }
}