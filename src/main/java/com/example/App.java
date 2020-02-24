package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.example.domain.customer.Customer;
import com.example.domain.customer.CustomerRepository;

@SpringBootApplication
public class App implements CommandLineRunner {
	CustomerRepository customerRepository;

	App(CustomerRepository aCustomerRepository) {
		this.customerRepository = aCustomerRepository;
	}

	@Override
	public void run(String... strings) throws Exception {
		// データ追加
		Customer created = customerRepository.save(new Customer(null, "Hidetoshi", "Dekisugi"));
		System.out.println(created + " is created!");
		// ページング処理
		Pageable pageable = PageRequest.of(0, 3);
		Page<Customer> page = customerRepository.findAllOrderByName(pageable);
		System.out.println("1ページあたりのデータ数 = " + page.getSize());
		System.out.println("現在のページ = " + page.getNumber());
		System.out.println("全ページ数 = " + page.getTotalPages());
		System.out.println("全データ数 = " + page.getTotalElements());
		page.getContent().forEach(System.out::println);
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
