package com.rishav.ecommercechatbot.service;

import com.rishav.ecommercechatbot.model.*;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Service
public class CsvDataLoaderService {

    public List<User> users = new ArrayList<>();
    public List<Product> products = new ArrayList<>();
    public List<Order> orders = new ArrayList<>();
    public List<OrderItem> orderItems = new ArrayList<>();
    public List<InventoryItem> inventoryItems = new ArrayList<>();
    public List<DistributionCenter> distributionCenters = new ArrayList<>();

    @PostConstruct
    public void loadCsvData() {
        loadUsers();
        loadProducts();
        loadOrders();
        loadOrderItems();
        loadInventoryItems();
        loadDistributionCenters();
    }

    private void loadUsers() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                getClass().getResourceAsStream("/data/users.csv"), StandardCharsets.UTF_8))) {
            br.readLine(); // skip header
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                User u = new User();
                u.setId(Long.parseLong(tokens[0]));
                u.setName(tokens[1]);
                u.setEmail(tokens[2]);
                u.setGender(tokens[3]);
                u.setCity(tokens[4]);
                users.add(u);
            }
            System.out.println("Loaded users: " + users.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Same structure for all other loaders

    private void loadProducts() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                getClass().getResourceAsStream("/data/products.csv"), StandardCharsets.UTF_8))) {
            br.readLine(); // skip header
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                Product p = new Product();
                p.setId(Long.parseLong(tokens[0]));
                p.setName(tokens[1]);
                p.setCategory(tokens[2]);
                p.setPrice(Double.parseDouble(tokens[3]));
                products.add(p);
            }
            System.out.println("Loaded products: " + products.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadOrders() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                getClass().getResourceAsStream("/data/orders.csv"), StandardCharsets.UTF_8))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                Order o = new Order();
                o.setId(Long.parseLong(tokens[0]));
                o.setUserId(Long.parseLong(tokens[1]));
                o.setOrderDate(tokens[2]);
                o.setStatus(tokens[3]);
                orders.add(o);
            }
            System.out.println("Loaded orders: " + orders.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadOrderItems() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                getClass().getResourceAsStream("/data/order_items.csv"), StandardCharsets.UTF_8))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                OrderItem oi = new OrderItem();
                oi.setId(Long.parseLong(tokens[0]));
                oi.setOrderId(Long.parseLong(tokens[1]));
                oi.setProductId(Long.parseLong(tokens[2]));
                oi.setQuantity(Integer.parseInt(tokens[3]));
                orderItems.add(oi);
            }
            System.out.println("Loaded order items: " + orderItems.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadInventoryItems() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                getClass().getResourceAsStream("/data/inventory_items.csv"), StandardCharsets.UTF_8))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                InventoryItem ii = new InventoryItem();
                ii.setId(Long.parseLong(tokens[0]));
                ii.setProductId(Long.parseLong(tokens[1]));
                ii.setDistributionCenterId(Long.parseLong(tokens[2]));
                ii.setStock(Integer.parseInt(tokens[3]));
                inventoryItems.add(ii);
            }
            System.out.println("Loaded inventory items: " + inventoryItems.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadDistributionCenters() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                getClass().getResourceAsStream("/data/distribution_centers.csv"), StandardCharsets.UTF_8))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                DistributionCenter dc = new DistributionCenter();
                dc.setId(Long.parseLong(tokens[0]));
                dc.setName(tokens[1]);
                dc.setCity(tokens[2]);
                distributionCenters.add(dc);
            }
            System.out.println("Loaded distribution centers: " + distributionCenters.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
