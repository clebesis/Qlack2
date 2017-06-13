package com.eurodyn.qlack2.fuse.search.impl;

import com.eurodyn.qlack2.fuse.search.api.AdminService;
import com.eurodyn.qlack2.fuse.search.impl.util.ESClient;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;
import org.ops4j.pax.cdi.api.OsgiServiceProvider;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Singleton
@OsgiServiceProvider(classes = {AdminService.class})
public class AdminServiceImpl implements AdminService {

  private static final Logger LOGGER = Logger.getLogger(AdminServiceImpl.class.getName());
  @Inject
  @Named("ESClient")
  private ESClient esClient;

  @Override
  public boolean createIndex(String indexName, String indexMapping) {
    /** If the index already exists return without doing anything. */
    if (indexExists(indexName)) {
      LOGGER.log(Level.WARNING, "Index already exists: {0}.", indexName);
      return false;
    }
//
//		// Create the index-create request.
//		try {
//			// If an indexMapping is provided creaate the index using this
//			// mapping, otherwise create the index with no specific mapping (ES
//			// will automatically map fields according to the underlying data
//			// types, see 'Field datatypes' on
//			// https://www.elastic.co/guide/en/elasticsearch/reference/current/mapping.html).
//			if (StringUtils.isNotBlank(indexMapping)) {
//				esClient.getClient().admin().indices().prepareCreate(indexName)
//						.setSource(indexMapping).execute().get();
//			} else {
//				esClient.getClient().admin().indices().prepareCreate(indexName).execute().get();
//			}
//		} catch (InterruptedException | ExecutionException e) {
//			throw new QSearchException("Could create index.", e);
//		}

    return true;
  }

  @Override
  public boolean deleteIndex(String indexName) {
//		// If the index does not exist return without doing anything.
//		if (!indexExists(indexName)) {
//			LOGGER.log(Level.WARNING, "Index does not exist: {0}.", indexName);
//			return false;
//		}
//
//		// Delete the index.
//		esClient.getClient().admin().indices().prepareDelete(indexName).execute();

    return true;
  }

  @Override
  public boolean createIndex(String indexName) {
    return createIndex(indexName, null);
  }

  @Override
  public boolean indexExists(String indexName) {
    try {
      System.out.println("--------------------- DOING CALL");
      try {
        Thread.sleep(10000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      final Response response = esClient.getClient().performRequest("GET", "/" + indexName);
      System.out.println("--------------------- AFTER CALL");
      System.out.println("**************************************");
      System.out.println(response.getStatusLine().getStatusCode());
      System.out.println();
      System.out.println(EntityUtils.toString(response.getEntity()));
      System.out.println("**************************************");
    } catch (IOException e) {
      e.printStackTrace();
    }
//		IndicesExistsResponse res;
//		try {
//			res = esClient.getClient().admin()
//					.indices().prepareExists(indexName).execute().get();
//		} catch (InterruptedException | ExecutionException e) {
//			throw new QSearchException("Could not check if index exists.", e);
//		}
//
//		return res.isExists();
    return true;
  }

  @Override
  public void updateTypeMapping(String indexName, String typeName, String indexMapping) {
//		try {
//			esClient.getClient().admin().indices().preparePutMapping(indexName)
//					.setType(typeName)
//					.setSource(indexMapping).execute().get();
//		} catch (InterruptedException | ExecutionException e) {
//			throw new QSearchException("Could update index mapping.", e);
//		}
  }

}
