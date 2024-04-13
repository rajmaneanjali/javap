package org.java.studentreceiptsproject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.java.studentreceiptsproject.model.ReceiptForm;
import org.java.studentreceiptsproject.service.ReceiptService;
import org.java.studentreceiptsproject.util.security.admin.BaseResource;
import org.java.studentreceiptsproject.util.security.admin.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("v1/admin/receipts")
@AllArgsConstructor
@CrossOrigin("*")
public class ReceiptController extends BaseResource {
	@Autowired
	private ReceiptService receiptService;
	
	@GetMapping
	List<ReceiptForm> getReceiptController(@RequestHeader("access-token")String token , HttpServletRequest request)
	{
		User user= getUser(request);
		if(user == null) return null;
		List<ReceiptForm> receiptList= receiptService.getReceiptService();
		return receiptList;
	}
	
	@GetMapping ("/{receiptno}")
	public ReceiptForm getReceiptByReceiptnoController(@PathVariable(value="receiptno") int receiptno, @RequestHeader("access-token")String token , HttpServletRequest request)
	{
		ReceiptForm receiptList = receiptService.getReceiptByReceiptnoService(receiptno);
		return receiptList;
	}
	
	@PostMapping
	public void insertReceiptController(@RequestBody ReceiptForm receiptForm, @RequestHeader("access-token")String token , HttpServletRequest request)
	{
		User user= getUser(request);
		if(user== null) return;
		receiptService.insertReceiptService(receiptForm);
	}
	
	@PutMapping
	
		public void updateReceiptController(@RequestBody ReceiptForm receiptForm , @RequestHeader("access-token")String token , HttpServletRequest request)
		{
			receiptService.updateReceiptService(receiptForm);
		}
	
	@DeleteMapping("/{receiptno}")
	
		public void deleteReceiptController(@PathVariable(value="receiptno") int receiptno,@RequestHeader("access-token")String token , HttpServletRequest request)
		{
			receiptService.deleteReceiptService(receiptno);
		}
	}
	
