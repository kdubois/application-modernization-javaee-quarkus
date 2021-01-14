package org.pwte.example.service;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

import com.ibm.cardinal.util.CardinalException;
import com.ibm.cardinal.util.CardinalLogger;
import com.ibm.cardinal.util.CardinalString;
import com.ibm.cardinal.util.ClusterObjectManager;
import com.ibm.cardinal.util.SerializationUtil;
import java.util.List;
import org.pwte.example.domain.Category;
import org.pwte.example.domain.Product;
import org.pwte.example.exception.CategoryDoesNotExist;
import org.pwte.example.exception.ProductDoesNotExistException;

/**
 * Service class for ProductSearchServiceImpl - Generated by Cardinal
 */

@Path("/ProductSearchServiceImplService")
public class ProductSearchServiceImplService {
    private static final Logger klu__logger = CardinalLogger.getLogger(ProductSearchServiceImplService.class);

    // default constructor service
    @POST
    @Path("/ProductSearchServiceImpl_default_ctor")
    @Produces(MediaType.APPLICATION_JSON) 
    public Response ProductSearchServiceImpl_default_ctor() {
        ProductSearchServiceImpl instProductSearchServiceImpl = new ProductSearchServiceImpl();
        String refid = ClusterObjectManager.putObject(instProductSearchServiceImpl);
        instProductSearchServiceImpl.setKlu__referenceID(refid);
        JsonObject jsonobj = Json
            .createObjectBuilder()
            .add("return_value", refid)
            .build();
        klu__logger.info("[ProductSearchServiceImplService] Returning JSON object: "+jsonobj.toString());
        return Response
            .status(Response.Status.OK)
            .entity(jsonobj)
            .build();
    }



    // health check service
    @GET 
    @Path("/health") 
    @Produces(MediaType.TEXT_HTML) 
    public String getHealth() { 
        klu__logger.info("[ProductSearchServiceImpl] getHealth() called");
        return "ProductSearchServiceImplService::Health OK"; 
    }



    // service for incrementing object reference count
    @POST
    @Path("/incObjectCount")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void incObjectCount(@FormParam("klu__referenceID") String klu__referenceID) {
        klu__logger.info("[ProductSearchServiceImplService] incObjectCount() called with ref: "+klu__referenceID);
        ClusterObjectManager.incObjectCount(klu__referenceID);
    }



    // service for decrementing object reference count
    @POST
    @Path("/decObjectCount")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void decObjectCount(@FormParam("klu__referenceID") String klu__referenceID) {
        klu__logger.info("[ProductSearchServiceImpl] decObjectCount() called with ref: "+klu__referenceID);
        ClusterObjectManager.decObjectCount(klu__referenceID);
    }



    // getter service for field "em" (generated)
    @GET 
    @Path("/get__em")
    @Produces(MediaType.APPLICATION_JSON) 
    public Response get__em(
        @FormParam("klu__referenceID") String klu__referenceID,
        @Context HttpServletResponse servletResponse
    ) {
        EntityManager response;
        ProductSearchServiceImpl instProductSearchServiceImpl = (ProductSearchServiceImpl)ClusterObjectManager.getObject(klu__referenceID);
        response = instProductSearchServiceImpl.em;
        JsonObjectBuilder jsonresp = Json.createObjectBuilder();
        
        // convert physical/proxy object(s) referenced by "response" to reference ID(s)
        String response_obj = SerializationUtil.encodeWithDynamicTypeCheck(response);
        JsonObject jsonobj = jsonresp.add("return_value", response_obj).build();


        klu__logger.info("[ProductSearchServiceImpl] Returning JSON object: "+jsonobj.toString());
        return Response
            .status(Response.Status.OK)
            .entity(jsonobj)
            .build();
    }



    // setter service for field "em" (generated)
    @POST
    @Path("/set__em")
    public void set__em(
        @FormParam("klu__referenceID") String klu__referenceID,
        @FormParam("em") String em,
        @Context HttpServletResponse servletResponse
    ) {
        
        // convert reference ID(s) stored in "em" to physical/proxy object(s)
        EntityManager em_fpar = (EntityManager)SerializationUtil.decodeWithDynamicTypeCheck(em);

        ProductSearchServiceImpl instProductSearchServiceImpl = (ProductSearchServiceImpl)ClusterObjectManager.getObject(klu__referenceID);
        instProductSearchServiceImpl.em = em_fpar;
    }


    @POST
    @Path("/loadCategory")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response loadCategory(
        @FormParam("klu__referenceID") String klu__referenceID,
        @FormParam("categoryId") String categoryId,
        @Context HttpServletResponse servletResponse
    ) {

        int categoryId_fpar = Integer.parseInt(categoryId);

        Category response;

        // dynamically dispatched method: using reference ID, get object from cluster object manager and
        // call method on the object
        ProductSearchServiceImpl instProductSearchServiceImpl = (ProductSearchServiceImpl)ClusterObjectManager.getObject(klu__referenceID);

        try {
            response = instProductSearchServiceImpl.loadCategory(categoryId_fpar);
        }
        catch (java.lang.Throwable t) {
            String msg = "Call to method loadCategory() of ProductSearchServiceImpl raised exception: "+t.getMessage();
            klu__logger.warning(msg);
            throw new WebApplicationException(msg, t, CardinalException.APPLICATION_EXCEPTION);
        }
        JsonObjectBuilder jsonresp = Json.createObjectBuilder();
        
        // convert physical/proxy object(s) referenced by "response" to reference ID(s)
        String response_obj = SerializationUtil.encodeWithDynamicTypeCheck(response);
        JsonObject jsonobj = jsonresp.add("return_value", response_obj).build();

        klu__logger.info("[ProductSearchServiceImpl] Returning JSON object: "+jsonobj.toString());
        return Response
            .status(Response.Status.OK)
            .entity(jsonobj)
            .build();

    }

    @POST
    @Path("/loadProduct")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response loadProduct(
        @FormParam("klu__referenceID") String klu__referenceID,
        @FormParam("productId") String productId,
        @Context HttpServletResponse servletResponse
    ) {

        int productId_fpar = Integer.parseInt(productId);

        Product response;

        // dynamically dispatched method: using reference ID, get object from cluster object manager and
        // call method on the object
        ProductSearchServiceImpl instProductSearchServiceImpl = (ProductSearchServiceImpl)ClusterObjectManager.getObject(klu__referenceID);

        try {
            response = instProductSearchServiceImpl.loadProduct(productId_fpar);
        }
        catch (java.lang.Throwable t) {
            String msg = "Call to method loadProduct() of ProductSearchServiceImpl raised exception: "+t.getMessage();
            klu__logger.warning(msg);
            throw new WebApplicationException(msg, t, CardinalException.APPLICATION_EXCEPTION);
        }
        JsonObjectBuilder jsonresp = Json.createObjectBuilder();
        
        // convert physical/proxy object(s) referenced by "response" to reference ID(s)
        String response_obj = SerializationUtil.encodeWithDynamicTypeCheck(response);
        JsonObject jsonobj = jsonresp.add("return_value", response_obj).build();

        klu__logger.info("[ProductSearchServiceImpl] Returning JSON object: "+jsonobj.toString());
        return Response
            .status(Response.Status.OK)
            .entity(jsonobj)
            .build();

    }

    @POST
    @Path("/loadProductsByCategory")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response loadProductsByCategory(
        @FormParam("klu__referenceID") String klu__referenceID,
        @FormParam("categoryId") String categoryId,
        @Context HttpServletResponse servletResponse
    ) {

        int categoryId_fpar = Integer.parseInt(categoryId);

        List<Product> response;

        // dynamically dispatched method: using reference ID, get object from cluster object manager and
        // call method on the object
        ProductSearchServiceImpl instProductSearchServiceImpl = (ProductSearchServiceImpl)ClusterObjectManager.getObject(klu__referenceID);

        try {
            response = instProductSearchServiceImpl.loadProductsByCategory(categoryId_fpar);
        }
        catch (java.lang.Throwable t) {
            String msg = "Call to method loadProductsByCategory() of ProductSearchServiceImpl raised exception: "+t.getMessage();
            klu__logger.warning(msg);
            throw new WebApplicationException(msg, t, CardinalException.APPLICATION_EXCEPTION);
        }
        JsonObjectBuilder jsonresp = Json.createObjectBuilder();
        
        // convert physical/proxy object(s) referenced by "response" to reference ID(s)
        String response_obj = SerializationUtil.encodeWithDynamicTypeCheck(response);
        JsonObject jsonobj = jsonresp.add("return_value", response_obj).build();

        klu__logger.info("[ProductSearchServiceImpl] Returning JSON object: "+jsonobj.toString());
        return Response
            .status(Response.Status.OK)
            .entity(jsonobj)
            .build();

    }

    @POST
    @Path("/getTopLevelCategories")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTopLevelCategories(
        @FormParam("klu__referenceID") String klu__referenceID,
        @Context HttpServletResponse servletResponse
    ) {

        List<Category> response;

        // dynamically dispatched method: using reference ID, get object from cluster object manager and
        // call method on the object
        ProductSearchServiceImpl instProductSearchServiceImpl = (ProductSearchServiceImpl)ClusterObjectManager.getObject(klu__referenceID);

        try {
            response = instProductSearchServiceImpl.getTopLevelCategories();
        }
        catch (java.lang.Throwable t) {
            String msg = "Call to method getTopLevelCategories() of ProductSearchServiceImpl raised exception: "+t.getMessage();
            klu__logger.warning(msg);
            throw new WebApplicationException(msg, t, CardinalException.APPLICATION_EXCEPTION);
        }
        JsonObjectBuilder jsonresp = Json.createObjectBuilder();
        
        // convert physical/proxy object(s) referenced by "response" to reference ID(s)
        String response_obj = SerializationUtil.encodeWithDynamicTypeCheck(response);
        JsonObject jsonobj = jsonresp.add("return_value", response_obj).build();

        klu__logger.info("[ProductSearchServiceImpl] Returning JSON object: "+jsonobj.toString());
        return Response
            .status(Response.Status.OK)
            .entity(jsonobj)
            .build();

    }

}