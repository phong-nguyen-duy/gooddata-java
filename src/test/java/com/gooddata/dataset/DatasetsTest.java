package com.gooddata.dataset;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gooddata.gdc.AboutLinks.Link;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

public class DatasetsTest {

    @SuppressWarnings("deprecation")
    @Test
    public void deserialize() throws Exception {
        final InputStream stream = getClass().getResourceAsStream("/dataset/datasetLinks.json");
        final Datasets datasets = new ObjectMapper().readValue(stream, Datasets.class);
        assertThat(datasets, is(notNullValue()));
        assertThat(datasets.getCategory(), is("singleloadinterface"));
        assertThat(datasets.getInstance(), is("MD::LDM::SingleLoadInterface"));
        assertThat(datasets.getSummary(), is("single loading interfaces"));

        final Collection<Link> links = datasets.getLinks();
        assertThat(links, is(notNullValue()));
        assertThat(links, hasSize(1));

        final Link link = links.iterator().next();
        assertThat(link, is(notNullValue()));
        assertThat(link.getIdentifier(), is("dataset.person"));
        assertThat(link.getUri(), is("/gdc/md/PROJECT_ID/ldm/singleloadinterface/dataset.person"));
        assertThat(link.getCategory(), is("dataset-singleloadinterface"));
        assertThat(link.getTitle(), is("Person"));
        assertThat(link.getSummary(), is("dataset single data loading interface specifications"));
    }
}
