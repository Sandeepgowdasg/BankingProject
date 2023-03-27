package dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import net.bytebuddy.dynamic.loading.InjectionClassLoader.Strategy;

@Entity
@Data
public class BankTransaction {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	double deposit;
	double withdraw;
	double balance;
	LocalDateTime datetime;
	
	
	
}
