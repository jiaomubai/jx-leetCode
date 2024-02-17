package bank;

import lombok.Getter;

import java.util.List;

/**
 * @author jiaoxian
 * @name bank
 * @date 2023/5/19 10:11
 * @description TODO
 */

@Getter
public class AlibabaAscpUopConsignorderNotifyRequest {

    private Request request;
    private String customerId;

    public void setRequest(Request obj1) {
        this.request = obj1;
    }

    public void setCustomerId(String s) {
        this.customerId = s;
    }

    @Getter
    public static class Request {

        private String supplierId;
        private String orderSource;
        private String bizOrderCode;
        private String supplierName;
        private String storeCode;
        private OrderItems orderItems;
        private String storeName;
        private ReceiverInfo receiverInfo;
        private SenderInfo senderInfo;
        private DeliverRequirement deliverRequirement;
        private String tmsServiceName;
        private String postMode;
        private long postFee;
        private String extraContent;
        private String orderCreateTime;
        private long itemsValue;
        private String klTradeId;
        private String buyerMessage;
        private String sellerId;
        private String sellerNick;
        private String bizType;
        private String transWareHouseAddress;
        private String transWareHouseCode;
        private String srcLgOrderCode;
        private String businessModel;
        private String saleOwner;
        private String sourcePlatformCode;
        private String esDate;
        private String deliveryTime;
        private String orderType;
        private String placeOrderTime;
        private String sourceConsignLp;
        private String payTime;
        public void setSupplierId(String s) {
            this.supplierId = s;
        }

        public void setOrderSource(String s) {
            this.orderSource = s;
        }

        public void setBizOrderCode(String scp0001) {
            this.bizOrderCode = scp0001;
        }

        public void setSupplierName(String s) {
            this.supplierName = s;
        }

        public void setStoreCode(String s) {
            this.storeCode = s;
        }

        public void setOrderItems(OrderItems obj2) {
            this.orderItems = obj2;
        }


        public void setStoreName(String s) {
            this.storeName = s;
        }

        public void setReceiverInfo(ReceiverInfo obj6) {
            this.receiverInfo = obj6;
        }

        public void setSenderInfo(SenderInfo obj7) {
            this.senderInfo = obj7;
        }

        public void setDeliverRequirement(DeliverRequirement obj8) {
            this.deliverRequirement = obj8;
        }

        public void setTmsServiceName(String s) {
            this.tmsServiceName = s;
        }

        public void setPostMode(String s) {
            this.postMode = s;
        }

        public void setPostFee(long l) {
            this.postFee = l;
        }

        public void setExtraContent(String s) {
            this.extraContent = s;
        }

        public void setOrderCreateTime(String s) {
            this.orderCreateTime = s;
        }

        public void setItemsValue(long l) {
            this.itemsValue = l;
        }

        public void setKlTradeId(String s) {
            this.klTradeId = s;
        }

        public void setBuyerMessage(String s) {
            this.buyerMessage = s;
        }

        public void setSellerId(String s) {
            this.sellerId = s;
        }

        public void setSellerNick(String s) {
            this.sellerNick = s;
        }

        public void setBizType(String s) {
            this.bizType = s;
        }

        public void setTransWareHouseAddress(String s) {
            this.transWareHouseAddress = s;
        }

        public void setTransWareHouseCode(String s) {
            this.transWareHouseCode = s;
        }

        public void setSrcLgOrderCode(String lpxxxx) {
            this.srcLgOrderCode = lpxxxx;
        }

        public void setBusinessModel(String s) {
            this.businessModel = s;
        }

        public void setSaleOwner(String s) {
            this.saleOwner = s;
        }

        public void setSourcePlatformCode(String tmgjzy) {
            this.sourcePlatformCode = tmgjzy;
        }

        public void setEsDate(String s) {
            this.esDate = s;
        }

        public void setDeliveryTime(String s) {
            this.deliveryTime = s;
        }

        public void setOrderType(String bfck) {
            this.orderType = bfck;
        }

        public void setPlaceOrderTime(String s) {
            this.placeOrderTime = s;
        }

        public void setSourceConsignLp(String s) {
            this.sourceConsignLp = s;
        }

        public void setPayTime(String s) {
            this.payTime = s;
        }
    }


    @Getter
    public static class OrderItems {
        private List<OrderItem> orderItem;
        public void setOrderItem(List<OrderItem> list4) {
            this.orderItem = list4;
        }
    }

    @Getter
    public static class OrderItem {
        private String subOrderCode;
        private String scItemId;
        private String outerId;
        private String barCode;
        private long quantity;
        private String scItemName;
        private String tradeOrerId;
        private String subTradeOrderId;
        private long itemAmount;
        private String scItemSpecification;
        private String tcOrderId;
        private String tcSubOrderId;
        public void setSubOrderCode(String s) {
            this.subOrderCode = s;
        }

        public void setScItemId(String s) {
            this.scItemId = s;
        }

        public void setOuterId(String s) {
            this.outerId = s;
        }

        public void setBarCode(String s) {
            this.barCode = s;
        }

        public void setQuantity(long l) {
            this.quantity = l;
        }

        public void setScItemName(String s) {
            this.scItemName = s;
        }

        public void setTradeOrerId(String s) {
            this.tradeOrerId = s;
        }

        public void setSubTradeOrderId(String s) {
            this.subTradeOrderId = s;
        }

        public void setItemAmount(long l) {
            this.itemAmount = l;
        }

        public void setScItemSpecification(String s) {
            this.scItemSpecification = s;
        }

        public void setTcOrderId(String s) {
            this.tcOrderId = s;
        }

        public void setTcSubOrderId(String s) {
            this.tcSubOrderId = s;
        }
    }


    @Getter
    public static class ReceiverInfo {
        private String oaidSourceCode;
        private String lat;
        private String lon;
        private String privacy;
        private String receiverSecurityMobile;
        private String aid;
        private String receiverPhone;
        private String receiverMobile;
        private String receiverName;
        private String receiverAddress;
        private String receiveTown;
        private String receiverArea;
        private String receiverCity;
        private String receiverProvince;
        private String receiverCountry;
        private String receiverZipCode;

        public void setOaidSourceCode(String s) {
            this.oaidSourceCode = s;
        }

        public void setLat(String s) {
            this.lat = s;
        }

        public void setLon(String s) {
            this.lon = s;
        }

        public void setPrivacy(String s) {
            this.privacy = s;
        }

        public void setReceiverSecurityMobile(String s) {
            this.receiverSecurityMobile = s;
        }

        public void setAid(String s) {
            this.aid = s;
        }

        public void setReceiverPhone(String s) {
            this.receiverPhone =s;
        }

        public void setReceiverMobile(String s) {
            this.receiverMobile =s;
        }

        public void setReceiverName(String s) {
            this.receiverName = s;
        }

        public void setReceiverAddress(String s) {
            this.receiverAddress = s;
        }

        public void setReceiveTown(String s) {
            this.receiveTown = s;
        }

        public void setReceiverArea(String s) {
            this.receiverArea = s;
        }

        public void setReceiverCity(String s) {
            this.receiverCity = s;
        }

        public void setReceiverProvince(String s) {
            this.receiverProvince = s;
        }

        public void setReceiverCountry(String s) {
            this.receiverCountry = s;
        }

        public void setReceiverZipCode(String s) {
            this.receiverZipCode = s;
        }
    }

    @Getter
    public static class SenderInfo {

        private String senderZipCode;
        private String senderCountry;
        private String senderProvince;
        private String senderCity;
        private String senderArea;
        private String senderTown;
        private String senderAddress;
        private String senderName;
        private String senderPhone;
        private String senderMobile;
        public void setSenderZipCode(String s) {
            this.senderZipCode = s;
        }

        public void setSenderCountry(String s) {
            this.senderCountry = s;
        }

        public void setSenderProvince(String s) {
            this.senderProvince = s;
        }

        public void setSenderCity(String s) {
            this.senderCity = s;
        }

        public void setSenderArea(String s) {
            this.senderArea = s;
        }

        public void setSenderTown(String s) {
            this.senderTown = s;
        }

        public void setSenderAddress(String s) {
            this.senderAddress = s;
        }

        public void setSenderName(String s) {
            this.senderName = s;
        }

        public void setSenderPhone(String s) {
            this.senderPhone = s;
        }

        public void setSenderMobile(String s) {
            this.senderMobile = s;
        }
    }

    @Getter
    public static class DeliverRequirement {

        private String appointDeliveryTime;
        private String appointArrivedTime;
        public void setAppointDeliveryTime(String s) {
            this.appointDeliveryTime = s;
        }

        public void setAppointArrivedTime(String s) {
            this.appointArrivedTime = s;
        }
    }
}
