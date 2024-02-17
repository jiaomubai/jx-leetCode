package isLongPressedName;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;

/**
 * @author jiaoxian
 * @name isLongPressedName
 * @date 2023/6/27 17:20
 * @description leetCode-925: 长按键入
 */
public class IsLongPressedName {

    public boolean isLongPressedName(String name, String typed) {
        int nameLength = name.length();
        int typedLength = typed.length();
        if (typedLength < nameLength) {
            return false;
        }

        int index = 0;
        for (int i = 0; i < nameLength; i++) {
            String tempName = String.valueOf(name.charAt(i));
            while (index < typedLength) {
                String tempTyped = String.valueOf(typed.charAt(i));
                if (tempName.equals(tempTyped)) {
                    index ++;
                }
            }
        }


        return true;
    }

    public static void main(String[] args) {
//        String name = "alex";
//        String typed = "aaaleeeeex";
//        IsLongPressedName isLongPressedName = new IsLongPressedName();
//        System.out.println(isLongPressedName.isLongPressedName(name, typed));
//
//        String referer = "https://yxydstest.yql.net/weidian/1857881280057600/1656B3538759B0BA54EF2B6EC8D673BA/3703031519?state=STATE&code=7091aa82b602bf2568831f96325ccc28";
//
//        System.out.println(referer.substring(referer.indexOf("/")));
//        String res;
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        long lt = new Long("1690528667729") - 60000;
//        Date date = new Date(lt);
//        res = simpleDateFormat.format(date);
//        System.out.println(res);
        // 2023-07-28 15:17:47



        String test = "traceId=xxxxxxxx&content={\"aesKeyVersion\":1,\"message\":{\"note\":\"\",\"group_status\":\"-1\",\"is_wtt_order\":\"null\",\"modify_price_enable\":\"1\",\"express_fee\":\"0.00\",\"argue_flag\":0,\"is_wei_order\":\"0\",\"express\":\"\",\"express_no\":\"\",\"discount_list\":[],\"total\":\"0.08\",\"seller_name\":\"irleJ+yELfAdbZtnuZ/z+gtQFCoaLfC1ubIZrMOXKjg=\",\"status_ori\":\"10\",\"is_over_sold\":\"0\",\"supplier_seller_id\":0,\"price\":\"0.08\",\"refund_status_ori\":\"0\",\"user_phone\":\"2vppYgjdociEMww4VCHIgITNmplnLD6xk/4RKAJK05k=\",\"original_total_price\":\"0.08\",\"order_type\":\"3\",\"seller_id\":\"1725002657\",\"quantity\":\"4\",\"confirm_expire\":\"\",\"status_desc\":\"待付款\",\"buyer_info\":{\"address\":\"VwceVw4IIPfNoRGMr0IDnepCe0WEKXmMo42jDOxlPxCS4U9BkN7LqopeHFNhTWFGYjfjD/jGYx7zsN/hHbLubbz4iVTobiRL3SNwil0p8kJFHa+qx2gI4vONmTXJOyO3\",\"province\":\"陕西\",\"city\":\"西安\",\"phone\":\"2vppYgjdociEMww4VCHIgITNmplnLD6xk/4RKAJK05k=\",\"idCardNo\":\"dtlt0rSHOLmrBO67n2M6JqKcaK3V9i31HtbYLdjz17U=\",\"name\":\"kkzkHfpZRFVl/Yl9HxO+Zs0XFV7jWCbqgb4gZwkukUE=\",\"buyer_id\":\"1754450450\",\"region\":\"雁塔区\",\"self_address\":\"Cl/D1NvSMSk/f66RlUAuSEPGffu760tvZO3vfxQDmLwAz06wGcY1rUIbjqLvxRkdGF1vLRJLCJE49GwrrbWn5g==\"},\"f_seller_id\":\"0\",\"is_close\":1,\"is_cpn_order\":\"0\",\"express_fee_num\":\"0.00\",\"express_note\":\"\",\"weixin\":\"dtlt0rSHOLmrBO67n2M6JqKcaK3V9i31HtbYLdjz17U=\",\"order_type_desc\":\"交易资金担保服务\",\"add_time\":\"2023-07-03+15:28:49\",\"items\":[{\"sku_merchant_code\":\"\",\"img\":\"https://si.geilicdn.com/pcitem1754450450-216300000188fc59544f0a22d246-unadjust_200_200.png?w=110&h=110&cp=1\",\"merchant_code\":\"product-test1\",\"quantity\":\"4\",\"total_price\":\"0.08\",\"item_id\":\"6432364078\",\"is_delivered\":0,\"deliver_id\":\"0\",\"refund_info\":{\"refund_status\":\"\",\"item_id\":\"\",\"item_sku_id\":\"\",\"refund_kind\":\"\",\"refund_fee\":\"\",\"refund_item_fee\":\"\",\"can_refund\":\"0\",\"refund_express_fee\":\"\"},\"item_name\":\"测试商品1\",\"sku_id\":\"0\",\"sub_order_id\":633929519539593,\"url\":\"https://weidian.com/item.html?itemID=6432364078\",\"sku_title\":\"\",\"price\":\"0.02\",\"deliver_status_desc\":\"待付款\",\"id\":633929519539593,\"can_deliver\":0}],\"order_id\":\"821764589118857\",\"express_type\":\"0\",\"status\":\"unpay\"},\"shopId\":1725002657,\"type\":\"weidian.order.non_payment\"}";

        test = test.substring(test.indexOf("content=") + 8);

        System.out.println(test);



    }

}
