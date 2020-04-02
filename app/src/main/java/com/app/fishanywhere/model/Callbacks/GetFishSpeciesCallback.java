package com.app.fishanywhere.model.Callbacks;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetFishSpeciesCallback {

    @SerializedName("term_id")
    @Expose
    public int termId;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("slug")
    @Expose
    public String slug;
    @SerializedName("term_group")
    @Expose
    public int termGroup;
    @SerializedName("term_taxonomy_id")
    @Expose
    public int termTaxonomyId;
    @SerializedName("taxonomy")
    @Expose
    public String taxonomy;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("parent")
    @Expose
    public int parent;

    @SerializedName("count")
    @Expose
    public int count;
    @SerializedName("filter")
    @Expose
    public String filter;
    @SerializedName("term_order")
    @Expose
    public String termOrder;

    public int getTermId() {
        return termId;
    }

    public void setTermId(int termId) {
        this.termId = termId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public int getTermGroup() {
        return termGroup;
    }

    public void setTermGroup(int termGroup) {
        this.termGroup = termGroup;
    }

    public int getTermTaxonomyId() {
        return termTaxonomyId;
    }

    public void setTermTaxonomyId(int termTaxonomyId) {
        this.termTaxonomyId = termTaxonomyId;
    }

    public String getTaxonomy() {
        return taxonomy;
    }

    public void setTaxonomy(String taxonomy) {
        this.taxonomy = taxonomy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getTermOrder() {
        return termOrder;
    }

    public void setTermOrder(String termOrder) {
        this.termOrder = termOrder;
    }


}
