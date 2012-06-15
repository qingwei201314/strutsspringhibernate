package samples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.Namespace;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.server.endpoint.annotation.XPathParam;
import org.springframework.ws.soap.SoapHeader;
import org.springframework.ws.soap.addressing.server.annotation.Action;
import org.w3c.dom.Element;
import samples.entity.Order;
import samples.service.OrderService;

@Endpoint
public class AnnotationOrderEndpoint {

	private final OrderService orderService;

	@Autowired
	public AnnotationOrderEndpoint(OrderService orderService) {
		this.orderService = orderService;
	}

	@PayloadRoot(localPart = "order", namespace = "http://samples")
	public void order(@RequestPayload Element orderElement) {
		Order order = createOrder(orderElement);
		orderService.createOrder(order);
	}

	@PayloadRoot(localPart = "orderRequest", namespace = "http://samples")
	@ResponsePayload
	@Action("http://samples/CreateOrder")
	public Order getOrder(@RequestPayload OrderRequest orderRequest,
			SoapHeader header) {
		checkSoapHeaderForSomething(header);
		return orderService.getOrder(orderRequest.getId());
	}

	@PayloadRoot(localPart = "orderRequest", namespace = "http://samples")
	@Namespace(prefix = "s", uri = "http://samples")
	@Action("http://samples/RequestOrder")
	public Order getOrder(@XPathParam("/s:orderRequest/@id") int orderId) {
		Order order = orderService.getOrder(orderId);
		// create Source from order and return it
	}

}
