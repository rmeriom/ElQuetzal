package mx.org.quetzal.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.org.quetzal.modelo.CatUsuario;
import mx.org.quetzal.modelo.Mascota;
import mx.org.quetzal.modelo.Visitas;
import mx.org.quetzal.repository.IVisitaRepository;
import mx.org.quetzal.service.IMascotaService;
import mx.org.quetzal.service.IUsuarioService;

@RestController
@RequestMapping(path = "/veterinaria")
public class VeterinariaController {

	@Autowired
	private IUsuarioService service;
	
	@Autowired
	private IVisitaRepository visitaService;
	
	@Autowired
	private IMascotaService mascotaService;
	
	@Autowired
	private IUsuarioService usuarioService;

	private HttpHeaders headers;

	@GetMapping(path = "/visitas/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findAll() {

		headers = new HttpHeaders();

		try {
			List<CatUsuario> list = service.findAll();

			if (list.isEmpty()) {

				headers.add("Message-Error", "No existen registros para mostrar");

				return new ResponseEntity<>(null, headers, HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<>(list, HttpStatus.OK);
			}
		} catch (SQLException e) {
			e.printStackTrace();

			headers.add("Message-Error", e.getMessage());

			return new ResponseEntity<>(null, headers, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			e.printStackTrace();

			headers.add("Message-Error", e.getMessage());

			return new ResponseEntity<>(null, headers, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(path = "/findById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findById(@PathVariable Long id) {

		headers = new HttpHeaders();

		try {
			CatUsuario pregunta = service.findById(id);

			if (pregunta == null) {

				headers.add("Message-Error", "No existen ningun registro con esas características");

				return new ResponseEntity<>(null, headers, HttpStatus.NOT_FOUND);
			} else {

				return new ResponseEntity<>(pregunta, HttpStatus.OK);
			}
		} catch (SQLException e) {
			e.printStackTrace();

			headers.add("Message-Error", e.getMessage());

			return new ResponseEntity<>(null, headers, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			e.printStackTrace();

			headers.add("Message-Error", e.getMessage());

			return new ResponseEntity<>(null, headers, HttpStatus.BAD_REQUEST);
		}
	}

	
	/*Crea las visitas*/
	@PostMapping(path = "/visitas/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> save(@RequestBody Visitas entity) {

		headers = new HttpHeaders();

		try {
			Visitas visita = visitaService.save(entity);
			if (visita == null) {

				headers.add("Message-Error", "No se almacenó el registro");

				return new ResponseEntity<>(null, headers, HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<>(visita, HttpStatus.OK);
			}

		} catch (Exception e) {
			e.printStackTrace();

			headers.add("Message-Error", e.getMessage());

			return new ResponseEntity<>(null, headers, HttpStatus.BAD_REQUEST);
		}
	}

	/*Crea las Mascotas*/
	
	@PostMapping(path = "/mascota/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> save(@RequestBody Mascota entity) {

		headers = new HttpHeaders();

		try {
			Mascota macota = mascotaService.save(entity);
			if (macota == null) {

				headers.add("Message-Error", "No se almacenó el registro");

				return new ResponseEntity<>(null, headers, HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<>(macota, HttpStatus.OK);
			}

		} catch (Exception e) {
			e.printStackTrace();

			headers.add("Message-Error", e.getMessage());

			return new ResponseEntity<>(null, headers, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	/*listar todas las mascotas junto con sus visitas a la veterinaria*/
	
	
	@PostMapping(path = "/mascota/findAll", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> allMascota() {

		headers = new HttpHeaders();

		try {
			List<Visitas> listvisitas = (List<Visitas>) visitaService.findAll();
			List<Mascota> listMacota =  mascotaService.findAll();

			if (listvisitas.isEmpty()) {

				headers.add("Message-Error", "No existen registros para mostrar");

				return new ResponseEntity<>(null, headers, HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<>(listvisitas, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();

			headers.add("Message-Error", e.getMessage());

			return new ResponseEntity<>(null, headers, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	/*búsqueda de mascotas usando el nombre del propietario*/
	
	
	@GetMapping(path = "/findByNombreProp/{etiqueta}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findByEtiqueta(@PathVariable String etiqueta) {

		headers = new HttpHeaders();

		try {

			List<CatUsuario> usuario = usuarioService.findByNombre(etiqueta);
			List<Mascota> listMacota =  mascotaService.findAll();
			
			List<Mascota> listrs = new ArrayList<>();
			
			listrs = listMacota.stream()
                    .filter(e -> usuario.contains(e)) 
                    .collect(Collectors.toList());

			if (usuario == null) {

				headers.add("Message-Error", "No existen ningun registro con esas características");

				return new ResponseEntity<>(null, headers, HttpStatus.NO_CONTENT);
			} else {

				return new ResponseEntity<>(listMacota, HttpStatus.OK);
			}
		} catch (SQLException e) {
			e.printStackTrace();

			headers.add("Message-Error", e.getMessage());

			return new ResponseEntity<>(null, headers, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			e.printStackTrace();

			headers.add("Message-Error", e.getMessage());

			return new ResponseEntity<>(null, headers, HttpStatus.BAD_REQUEST);
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
