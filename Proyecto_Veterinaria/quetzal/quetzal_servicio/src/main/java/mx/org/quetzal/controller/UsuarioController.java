package mx.org.quetzal.controller;

import java.sql.SQLException;
import java.util.List;

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
import mx.org.quetzal.service.IUsuarioService;

@RestController
@RequestMapping(path = "/propietario")
public class UsuarioController {

	@Autowired
	private IUsuarioService service;

	private HttpHeaders headers;

	@GetMapping(path = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
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

				headers.add("Message-Error", "No existen ningun registro con esas caracter??sticas");

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

	@PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> save(@RequestBody CatUsuario entity) {

		headers = new HttpHeaders();

		try {
			CatUsuario pregunta = service.save(entity);
			if (pregunta == null) {

				headers.add("Message-Error", "No se almacen?? el registro");

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

	@PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody CatUsuario entity) {

		headers = new HttpHeaders();

		try {
			CatUsuario pregunta = service.update(entity);
			if (pregunta == null) {

				headers.add("Message-Error", "No se actualiz?? el registro");

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

	@DeleteMapping(path = "/deleteById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteById(@PathVariable Long id) {

		headers = new HttpHeaders();

		try {

			service.deteleById(id);

			return new ResponseEntity<>(null, HttpStatus.OK);
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
