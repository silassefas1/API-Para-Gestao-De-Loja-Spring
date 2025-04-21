package com.silassefas.apigestaodeloja.configuration;

import com.silassefas.apigestaodeloja.enums.UserType;
import com.silassefas.apigestaodeloja.model.Product;
import com.silassefas.apigestaodeloja.model.User;
import com.silassefas.apigestaodeloja.repository.ProductRepository;
import com.silassefas.apigestaodeloja.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.util.List;

@Configuration
@Profile("dev")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    /* Para testar a aplicação iniciando-a com alguns cadastras, eu fiz esta classe, pois criar um arquivo data.sql
    estava dando erro na hora de criar a tabela no banco de dados. Acredito que esta tenha sido a solução mais prática */
    public void run(String... args) {

        User userTest1 = new User(null, "João da Silva", UserType.INDIVIDUAL, "12345678900", "joao.silva@example.com", "senha123", "(21) 99876-5432", "Rua das Flores, 123, Rio de Janeiro, RJ, Brasil");
        User userTest2 = new User(null, "Maria Santos", UserType.INDIVIDUAL, "23456789011", "maria.santos@example.com", "senha456", "(11) 98765-4321", "Av. Paulista, 456, São Paulo, SP, Brasil");
        User userTest3 = new User(null, "Tech Innovators Ltd.", UserType.BUSINESS, "34567890000177", "contact@techinnovators.com", "senhaCorporativa1", "(31) 94567-8901", "Rua dos Três Irmãos, 789, Belo Horizonte, MG, Brasil");
        User userTest4 = new User(null, "Global Solutions Inc.", UserType.BUSINESS, "45678901000166", "info@globalsolutions.com", "senhaCorporativa2", "(71) 96321-4321", "Rua do Comércio, 1011, Salvador, BA, Brasil");
        userRepository.saveAll(List.of(userTest1, userTest2, userTest3, userTest4)); userRepository.saveAll(List.of(userTest1, userTest2,userTest3,userTest4));

        Product product1 = new Product(null, "iPhone 14 Pro", "Smartphone Apple com tela Super Retina XDR de 6.1 polegadas, chip A16 Bionic e câmera de 48 MP.", new BigDecimal("9999.00"), "Celulares");
        Product product2 = new Product(null, "Samsung Galaxy S23 Ultra", "Smartphone Samsung com tela Dynamic AMOLED 2X de 6.8 polegadas, S Pen e câmera de 200 MP.", new BigDecimal("8599.00"), "Celulares");
        Product product3 = new Product(null, "Xiaomi 13 Pro", "Smartphone Xiaomi com câmera Leica de 50 MP, Snapdragon 8 Gen 2 e tela AMOLED 120Hz.", new BigDecimal("6499.00"), "Celulares");
        Product product4 = new Product(null, "MacBook Pro M2", "Notebook Apple com chip M2, tela Retina de 13.3 polegadas e bateria de longa duração.", new BigDecimal("13499.00"), "Computadores");
        Product product5 = new Product(null, "Dell XPS 15", "Notebook Dell com processador Intel Core i7, 16GB RAM, SSD 512GB e tela 4K Ultra HD.", new BigDecimal("11999.00"), "Computadores");
        Product product6 = new Product(null, "Asus ROG Strix G16", "Notebook gamer com Intel Core i9, RTX 4070, 32GB RAM e tela de 240Hz.", new BigDecimal("13999.00"), "Computadores");
        Product product7 = new Product(null, "Teclado Mecânico Logitech G915", "Teclado mecânico sem fio com switches low-profile, iluminação RGB e tecnologia LIGHTSPEED.", new BigDecimal("999.00"), "Acessórios para Computadores");
        Product product8 = new Product(null, "Mouse Gamer Razer DeathAdder V3", "Mouse ergonômico com sensor óptico de 30.000 DPI e switches ópticos para alta precisão.", new BigDecimal("699.00"), "Acessórios para Computadores");
        Product product9 = new Product(null, "Monitor Gamer LG UltraGear 27”", "Monitor de 27 polegadas com taxa de atualizaç��o de 165Hz, 1ms de tempo de resposta e tecnologia G-Sync.", new BigDecimal("2499.00"), "Acessórios para Computadores");
        Product product10 = new Product(null, "Fone de Ouvido Bluetooth Sony WH-1000XM5", "Headphone sem fio com cancelamento de ruído ativo e áudio de alta resolução.", new BigDecimal("1799.00"), "Acessórios para Celulares");
        Product product11 = new Product(null, "Carregador Turbo 30W Anker", "Carregador rápido compatível com iPhone, Samsung e outros dispositivos via USB-C.", new BigDecimal("199.00"), "Acessórios para Celulares");
        Product product12 = new Product(null, "Capa de Silicone para iPhone 14", "Capa protetora de silicone original Apple, com toque suave e proteção contra quedas.", new BigDecimal("249.00"), "Acessórios para Celulares");

        productRepository.saveAll(List.of(product1, product2, product3, product4, product5, product6, product7, product8, product9, product10, product11, product12));
    }
}
