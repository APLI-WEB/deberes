package com.mycompany.romerito;

import com.mycompany.bromeroo.DetallePedido;
import com.mycompany.romerito.util.JsfUtil;
import com.mycompany.romerito.util.PaginationHelper;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("detallePedidoController")
@SessionScoped
public class DetallePedidoController implements Serializable {

    private DetallePedido current;
    private DataModel items = null;
    @EJB
    private com.mycompany.romerito.DetallePedidoFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public DetallePedidoController() {
    }

    public DetallePedido getSelected() {
        if (current == null) {
            current = new DetallePedido();
            current.setDetallePedidoPK(new com.mycompany.bromeroo.DetallePedidoPK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private DetallePedidoFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (DetallePedido) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new DetallePedido();
        current.setDetallePedidoPK(new com.mycompany.bromeroo.DetallePedidoPK());
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            current.getDetallePedidoPK().setCodigoPedido(current.getPedido().getCodigoPedido());
            current.getDetallePedidoPK().setCodigoProducto(current.getProducto().getCodigoProducto());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("DetallePedidoCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (DetallePedido) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            current.getDetallePedidoPK().setCodigoPedido(current.getPedido().getCodigoPedido());
            current.getDetallePedidoPK().setCodigoProducto(current.getProducto().getCodigoProducto());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("DetallePedidoUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (DetallePedido) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("DetallePedidoDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public DetallePedido getDetallePedido(com.mycompany.bromeroo.DetallePedidoPK id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = DetallePedido.class)
    public static class DetallePedidoControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            DetallePedidoController controller = (DetallePedidoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "detallePedidoController");
            return controller.getDetallePedido(getKey(value));
        }

        com.mycompany.bromeroo.DetallePedidoPK getKey(String value) {
            com.mycompany.bromeroo.DetallePedidoPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.mycompany.bromeroo.DetallePedidoPK();
            key.setCodigoPedido(Integer.parseInt(values[0]));
            key.setCodigoProducto(values[1]);
            return key;
        }

        String getStringKey(com.mycompany.bromeroo.DetallePedidoPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getCodigoPedido());
            sb.append(SEPARATOR);
            sb.append(value.getCodigoProducto());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof DetallePedido) {
                DetallePedido o = (DetallePedido) object;
                return getStringKey(o.getDetallePedidoPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + DetallePedido.class.getName());
            }
        }

    }

}
