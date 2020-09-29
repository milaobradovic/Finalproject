package tests;

public abstract class BasicTest {

	
	apstraktna klasa koja sadrži sve zajedničke funkcionalnosti za sve test klase
	od dodatnih atributa ima:
	baseUrl 
	imejl i lozinku demo korisnika customer@dummyid.com/12345678a
	BeforeClass metoda koja konfiguriše Selenium drajver
	AfterMethod metoda koja u slučaju pada testa kreira screenshot stranice i te slike čuva u okviru screenshots direktorijuma. Nevezano za ishod testa metoda uvek briše sve kolačiće.
	AfterClass metoda koja zatvara sesiju drajvera
	sve ostale test klase nasleđuju ovu klasu


}
