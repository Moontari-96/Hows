package com.hows.history.service;

import com.hows.order.dao.OrderDAO;
import com.hows.order.dto.OrderDTO;
import com.hows.order.dto.OrderListDTO;
import com.hows.product.dao.ReviewDAO;
import com.hows.product.dto.ImageDTO;
import com.hows.product.dto.ReviewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HistoryService {

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private ReviewDAO reviewDAO;

    /** My 주문 목록 **/
    public List<?> myOrder (int memberSeq) {
        List<OrderDTO> list = orderDAO.myOrder(memberSeq);
        List<Map<String, ?>> mapList = new ArrayList<>();
        for(OrderDTO dto : list) {
            int orderSeq = dto.getOrder_seq();
            List<HashMap<String, Object>> myOrderList = orderDAO.myOrderList(orderSeq);
            Map<String, Object> map = new HashMap<>();
            map.put("myOrder", dto);
            map.put("myOrderList", myOrderList);
            mapList.add(map);
        }

        return mapList;
    }

    /** Review 목록 **/
    public List<?> myReview (String memberId) {
        List<ReviewDTO> list = reviewDAO.myReview(memberId);
        List<Map<String, ?>> mapList = new ArrayList<>();
        for(ReviewDTO dto : list) {
            int reviewSeq = dto.getReview_seq();
            List<ImageDTO> reviewImage = reviewDAO.myReviewImage(reviewSeq);
            Map<String, Object> map = new HashMap<>();
            map.put("myReview", dto);
            map.put("myReviewImage", reviewImage);
        }
        return mapList;
    }

}
