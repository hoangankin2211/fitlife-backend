package com.FitnessApp.Controller;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import com.FitnessApp.DTO.Request.FetchExerciseRequest;
import com.FitnessApp.DTO.Request.PageRequest;
import com.FitnessApp.DTO.Views.ExerciseViews;
import com.FitnessApp.Exceptions.AppException.NotFoundException;
import com.FitnessApp.Model.Exercise;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.*;

import com.FitnessApp.DTO.DataClass.ResponseObject;
import com.FitnessApp.Utils.JwtTokenUtils;
import com.FitnessApp.Model.User;
import com.FitnessApp.Service.User.UserService;
import com.FitnessApp.Service.ExcerciseService.ExerciseService;

@RestController
@AllArgsConstructor
@RequestMapping("/exercise")
public class ExerciseController {

	private final ExerciseService eService;

	@GetMapping("/{id}")
	@JsonView(ExerciseViews.Detail.class)
	public ResponseEntity<?> getExerciseById(@PathVariable Long id) {
		return ResponseEntity.ok(eService.findById(id));
	}

	@GetMapping
	@JsonView(ExerciseViews.Summary.class)
	public ResponseEntity<?> getExercises(@RequestBody PageRequest pageRequest) {
		return ResponseEntity.ok(eService.fetchExercises(pageRequest));
	}

	@GetMapping("/search")
	@JsonView(ExerciseViews.Summary.class)
	public ResponseEntity<?> searchExercise(@RequestBody FetchExerciseRequest request){
		return ResponseEntity.ok(eService.searchExercise(request));
	}

}
