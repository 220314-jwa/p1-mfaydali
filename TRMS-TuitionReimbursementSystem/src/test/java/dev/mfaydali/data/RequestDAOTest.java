//package dev.mfaydali.data;
//
//import dev.mfaydali.models.Request;
//import dev.mfaydali.data.RequestDAO;
//import dev.mfaydali.data.RequestDAOImp;
//
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertNotEquals;
//
//public class RequestDAOTest {
//
//    RequestDAO requestDao = DAOFactory.getRequestDAO();
//    RequestService requestService = new RequestServiceImp(requestRepo);
//    Request requestOne = requestService.getRequest(1);
//    Request toBeDeleted = requestService.addRequest(requestOne);
//
//    @Test
//    void getRequest() {
//
//        Request actual = requestService.getRequest(1);
//        assertNotEquals(null, actual);
//    }
//
//    @Test
//    void getAllRequests() {
//
//        List<Request> actual = requestService.getAllRequests();
//        assertNotEquals(null, actual);
//    }
//
//    @Test
//    void addRequest() {
//
//        Request actual = requestService.addRequest(requestOne);
//        assertNotEquals(null, actual);
//    }
//
//    @Test
//    void updateRequest() {
//
//        Request actual = requestService.updateRequest(requestOne);
//        assertNotEquals(null, actual);
//
//    }
//
//    @Test
//    void deleteRequest() {
//
//        Request actual = requestService.deleteRequest(toBeDeleted);
//        assertNotEquals(null, actual);
//
//    }
//
//    @Test
//    void requestsForSupervisor() {
//
//        List<Request> actual = requestService.requestsForSupervisor(2);
//        assertNotEquals(null, actual);
//
//    }
//
//    @Test
//    void requestsForDeptHead() {
//
//        List<Request> actual = requestService.requestsForDeptHead(2);
//        assertNotEquals(null, actual);
//
//    }
//
//    @Test
//    void requestsForBenco() {
//
//        List<Request> actual = requestService.requestsForBenco();
//        assertNotEquals(null, actual);
//
//    }
//
//    @Test
//    void  requestsForEmployee() {
//
//        List<Request> actual = requestService.requestsForEmployee(2);
//        assertNotEquals(null, actual);
//
//    }
//
//    @Test
//    void resolvedRequests() {
//
//        List<Request> actual = requestService.resolvedRequests(10);
//        assertNotEquals(null, actual);
//
//    }
//}
