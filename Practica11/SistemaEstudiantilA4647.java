package Practica11;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.geometry.Insets;

import java.io.InputStream;
import java.util.Optional;
import java.util.regex.Pattern;

public class SistemaEstudiantilA4647 extends Application {

    public static class Estudiante {
        private final StringProperty matricula;
        private final StringProperty nombre;
        private final StringProperty apellido;
        private final IntegerProperty semestre;


        public Estudiante(String matricula, String nombre, String apellido, int semestre) {
            this.matricula = new SimpleStringProperty(matricula);
            this.nombre = new SimpleStringProperty(nombre);
            this.apellido = new SimpleStringProperty(apellido);
            this.semestre = new SimpleIntegerProperty(semestre);
        }

        public String getMatricula() {return matricula.get();}
        public void setMatricula(String value) {matricula.set(value);}
        public StringProperty matriculaProperty() {return matricula;}

        public String getNombre() { return nombre.get(); }
        public void setNombre(String value) { nombre.set(value); }
        public StringProperty nombreProperty() { return nombre; }

        public String getApellido() { return apellido.get(); }
        public void setApellido(String value) { apellido.set(value); }
        public StringProperty apellidoProperty() { return apellido; }

        public int getSemestre() { return semestre.get(); }
        public void setSemestre(int value) { semestre.set(value); }
        public IntegerProperty semestreProperty() { return semestre; }
    }

    public static class CampoIbarraValidado extends TextField {
        private final boolean requerido;
        private final String regexPattern;

        public CampoIbarraValidado(boolean requerido, String tipo) {
            this.requerido = requerido;

            switch (tipo.toLowerCase()) {
                case "matricula":
                    this.regexPattern = "^[0-9]{7}$";
                    break;
                case "numero":
                    this.regexPattern = "^[0-9]+$";
                    break;
                default:
                    this.regexPattern = "^[A-Za-zÁ-ÿ ]+$";
                    break;
            }

            this.textProperty().addListener((observable, oldValue, newValue) -> validate());
        }

        public boolean validate() {
            String text = getText() == null ? "": getText().trim();

            if(requerido && text.isEmpty()) {
                aplicarEstiloError(true);
                return false;
            }

            if (!text.isEmpty() && !Pattern.matches(regexPattern, text.trim())) {
                aplicarEstiloError(true);
                return false;
            }

            aplicarEstiloError(false);
            return true;
        }

        private void aplicarEstiloError(boolean invalid) {
            if (invalid) {
                if (!this.getStyleClass().contains("campo-invalido")) {
                    this.getStyleClass().add("campo-invalido");
                }

            } else  {
                this.getStyleClass().remove("campo-invalido");
            }
        }
    }

    public static class Boton14Estilizado extends Button {
        public Boton14Estilizado(String text) {
            super(text);
            this.getStyleClass().add("boton-15");
            this.setOnMouseEntered(event -> {
                this.setScaleX(1.05);
                this.setScaleY(1.05);
            });

            this.setOnMouseExited(event -> {
                this.setScaleX(1.0);
                this.setScaleY(1.0);
            });
        }
    }

    private final ObservableList<Estudiante> listaEstudiantes = FXCollections.observableArrayList();
    private TableView<Estudiante> tablaEstudiantes;

    private CampoIbarraValidado campoMatricula;
    private CampoIbarraValidado campoNombre;
    private CampoIbarraValidado campoApellido;
    private CampoIbarraValidado campoSemestre;

    private Boton14Estilizado botonAgregar;
    private Boton14Estilizado botonActualizar;
    private Boton14Estilizado botonEliminar;
    private Button botonLimpiar;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("SISTEMA DE GESTION ESTUDIANTIL");

        BorderPane root = new BorderPane();
        root.setTop(crearMenu(primaryStage));
        root.setCenter(crearTablaEstudiantes());
        root.setRight(crearFormularioCRUD());
        cargarDatosDePrueba();
        Scene scene = new Scene(root, 950, 600);

        KeyCombination comboLimpiar = new KeyCodeCombination(KeyCode.L, KeyCombination.CONTROL_DOWN);
        scene.setOnKeyPressed(event -> {
            if (comboLimpiar.match(event)) {
                limpiarCampos();
            }
        });


        String cssFile = "estilos_2094647.css";
        String cssPath = getClass().getResource(cssFile).toExternalForm();
        scene.getStylesheets().add(cssPath);

        try {
            InputStream is = getClass().getResourceAsStream("recursos_Ibarra/logo.png");
            if (is != null) {
                primaryStage.getIcons().add(new Image(is));
            }
        } catch (Exception e) {
            System.err.println("ERROR CARGANDO EL ÍCONO DE LA APLICACIÓN: " + e.getMessage());
        }

        primaryStage.setScene(scene);
        primaryStage.setMinHeight(500);
        primaryStage.setMinWidth(800);
        primaryStage.show();
    }

    private MenuBar crearMenu(Stage stage) {
        MenuBar menuBar = new MenuBar();
        menuBar.setId("menu-personalizado");

        Menu menuArchivo = new Menu("Archivo");
        MenuItem salir = new MenuItem("Salir");
        salir.setOnAction(e -> Platform.exit());
        menuArchivo.getItems().add(salir);

        Menu menuAyuda = new Menu("Ayuda");
        MenuItem itemAcercaDe = new MenuItem("Acerca de...");
        itemAcercaDe.setOnAction(e -> {
            mostrarDialogoAcercaDe();
        });
        menuAyuda.getItems().add(itemAcercaDe);
        menuBar.getMenus().addAll(menuArchivo, menuAyuda);
        return menuBar;
    }

    private Node crearTablaEstudiantes() {
        tablaEstudiantes = new TableView<>();
        tablaEstudiantes.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN);

        TableColumn<Estudiante, String> colMatricula = new TableColumn<>("Matricula");
        colMatricula.setCellValueFactory(new PropertyValueFactory<>("matricula"));
        colMatricula.setPrefWidth(120);

        TableColumn<Estudiante, String> colNombre = new TableColumn<>("Nombre");
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colNombre.setPrefWidth(150);

        TableColumn<Estudiante, String> colApellido = new TableColumn<>("Apellido");
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        colApellido.setPrefWidth(150);

        TableColumn<Estudiante, Integer> colSemestre = new TableColumn<>("Semestre");
        colSemestre.setCellValueFactory(new PropertyValueFactory<>("semestre"));
        colSemestre.setPrefWidth(100);

        tablaEstudiantes.getColumns().addAll(colMatricula, colNombre, colApellido, colSemestre);
        tablaEstudiantes.setItems(listaEstudiantes);

        tablaEstudiantes.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldSelection, newSelection) -> {
                    if (newSelection != null) {
                        popularFormulario(newSelection);
                    }
                }
        );

        VBox contenedor = new VBox(tablaEstudiantes);
        contenedor.setPadding(new Insets(10));
        VBox.setVgrow(tablaEstudiantes, Priority.ALWAYS);
        return contenedor;
    }

    private Node crearFormularioCRUD() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(15));
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setAlignment(Pos.TOP_CENTER);

        Label titulo = new Label("GESTION DE ESTUDIANTES");
        titulo.setStyle("-fx-font-size: 1.5em; -fx-font-weight: bold; -fx-text-fill: #333;");
        GridPane.setColumnSpan(titulo, 2);
        grid.add(titulo, 0, 0);

        grid.add(new Label("Matrícula:"), 0, 1);
        campoMatricula = new CampoIbarraValidado(true, "matricula");
        campoMatricula.setPromptText("Ej. 2094647");
        grid.add(campoMatricula, 1, 1);

        grid.add(new Label("Nombre:"), 0, 2);
        campoNombre = new CampoIbarraValidado(true, "texto");
        campoNombre.setPromptText("Nombre(s)");
        grid.add(campoNombre, 1, 2);

        grid.add(new Label("Apellido:"), 0, 3);
        campoApellido = new CampoIbarraValidado(true, "texto");
        campoApellido.setPromptText("Apellido(s)");
        grid.add(campoApellido, 1, 3);

        grid.add(new Label("Semestre:"), 0, 4);
        campoSemestre = new CampoIbarraValidado(true, "numero");
        campoSemestre.setPromptText("Ej. 3");
        grid.add(campoSemestre, 1, 4);

        botonAgregar = new Boton14Estilizado("Agregar");
        botonAgregar.setOnAction(e -> handleAgregar());

        botonActualizar = new Boton14Estilizado("Actualizar");
        botonActualizar.setOnAction(e -> handleActualizar());

        botonEliminar = new Boton14Estilizado("Eliminar");
        botonEliminar.setOnAction(e -> handleEliminar());

        botonLimpiar = new Button("Limpiar");
        botonLimpiar.getStyleClass().add("boton-limpiar");
        botonLimpiar.setOnAction(e -> limpiarCampos());

        HBox fila1 = new HBox(10, botonAgregar, botonActualizar);
        HBox fila2 = new HBox(10, botonEliminar, botonLimpiar);

        fila1.setAlignment(Pos.CENTER);
        fila2.setAlignment(Pos.CENTER);

        double anchoBoton = 180;

        botonAgregar.setPrefWidth(anchoBoton);
        botonActualizar.setPrefWidth(anchoBoton);
        botonEliminar.setPrefWidth(anchoBoton);
        botonLimpiar.setPrefWidth(anchoBoton);

        GridPane.setColumnSpan(fila1, 2);
        GridPane.setColumnSpan(fila2, 2);

        grid.add(fila1, 0, 5);
        grid.add(fila2, 0, 6);

        VBox contenedorFormulario = new VBox(grid);
        contenedorFormulario.setPadding(new Insets(10));
        contenedorFormulario.setPrefWidth(350);
        contenedorFormulario.setStyle("-fx-background-color: #f4f4f4;");

        return contenedorFormulario;
    }

    private void cargarDatosDePrueba() {
        listaEstudiantes.add(new Estudiante("2094647", "Alexis", "Ibarra", 5));
        listaEstudiantes.add(new Estudiante("2047453", "Roberto", "Sanchez Santoyo",  6));
        listaEstudiantes.add(new Estudiante("2095719", "Anna Cecilia", "García Zambrano", 1));
    }

    private void popularFormulario(Estudiante est) {
        if (est == null) return;
        campoMatricula.setText(est.getMatricula());
        campoNombre.setText(est.getNombre());
        campoApellido.setText(est.getApellido());
        campoSemestre.setText(String.valueOf(est.getSemestre()));

        campoMatricula.setDisable(true);
        botonAgregar.setDisable(true);
        botonActualizar.setDisable(false);
        botonEliminar.setDisable(false);
    }

    private void limpiarCampos() {
        campoMatricula.clear();
        campoNombre.clear();
        campoApellido.clear();
        campoSemestre.clear();

        campoMatricula.setDisable(false);
        botonAgregar.setDisable(false);
        botonActualizar.setDisable(true);
        botonEliminar.setDisable(true);

        tablaEstudiantes.getSelectionModel().clearSelection();
        campoMatricula.requestFocus();
    }

    private void handleAgregar() {
        boolean esMatriculaValida = campoMatricula.validate();
        boolean esNombreValido = campoNombre.validate();
        boolean esApellidoValido = campoApellido.validate();
        boolean esSemestreValido = campoSemestre.validate();

        if (!esMatriculaValida || !esNombreValido || !esApellidoValido || !esSemestreValido) {
            mostrarDialogoError("Formulario incompleto. Por favor, revise los campos marcados en rojo.");
            return;
        }

        int semestreInt = Integer.parseInt(campoSemestre.getText());
        if (semestreInt < 1 || semestreInt > 10) {
            mostrarDialogoError("El semestre debe estar entre 1 y 10");
            campoSemestre.aplicarEstiloError(true);
            return;
        }

        String matricula = campoMatricula.getText();
        for (Estudiante est : listaEstudiantes) {
            if (est.getMatricula().equals(matricula)) {
                mostrarDialogoError("La matrícula: " + matricula + " ya existe.");
                campoMatricula.aplicarEstiloError(true);
                return;
            }
        }

        listaEstudiantes.add(new Estudiante(
                matricula,
                campoNombre.getText(),
                campoApellido.getText(),
                Integer.parseInt(campoSemestre.getText())
        ));

        limpiarCampos();
    }

    private void handleActualizar() {
        Estudiante seleccionado = tablaEstudiantes.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarDialogoError("Seleccione un estudiante primero.");
            return;
        }

        if (!campoNombre.validate() || !campoApellido.validate() || !campoSemestre.validate()) {
            mostrarDialogoError("CAMPOS INVÁLIDOS");
            return;
        }


        seleccionado.setNombre(campoNombre.getText());
        seleccionado.setApellido(campoApellido.getText());
        seleccionado.setSemestre(Integer.parseInt(campoSemestre.getText()));

        tablaEstudiantes.refresh();
        limpiarCampos();

    }

    private void handleEliminar() {
        Estudiante seleccionado = tablaEstudiantes.getSelectionModel().getSelectedItem();

        if (seleccionado == null) {
            mostrarDialogoError("Seleccione un estudiante primero.");
            return;
        }

        Optional<ButtonType> resultado = mostrarDialogoConfirmacion(
                "¿Seguro de que desea eliminar a: " +
                        seleccionado.getNombre() + " " + seleccionado.getApellido() + "?"
        );

        if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
            listaEstudiantes.remove(seleccionado);
            limpiarCampos();
        }
    }

    private void mostrarDialogoError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Datos Incorrectos");
        alert.setContentText(mensaje);
        alert.getDialogPane().getStylesheets().add(getClass().getResource("estilos_2094647.css").toExternalForm());
        alert.getDialogPane().getStyleClass().add("dialogo-error");

        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        try {
            stage.getIcons().add(new Image(getClass().getResourceAsStream("recursos_Ibarra/error.png")));
        } catch (Exception e) {}

        alert.showAndWait();
    }

    private Optional<ButtonType> mostrarDialogoConfirmacion(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Confirmar Acción");
        alert.setContentText(mensaje);
        alert.getDialogPane().getStylesheets().add(getClass().getResource("estilos_2094647.css").toExternalForm());
        alert.getDialogPane().getStyleClass().add("dialogo-confirm");

        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        try {
            stage.getIcons().add(new Image(getClass().getResourceAsStream("recursos_Ibarra/pregunta.png")));
        } catch (Exception e) { }

        return alert.showAndWait();
    }

    private void mostrarDialogoAcercaDe() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Acerca de SistemaEstudiantil");
        alert.setHeaderText("Práctica 11: JavaFX");
        alert.setContentText(
                "Aplicación creada por: Alexis Ibarra Rodríguez\nMatrícula: 2094647\n" +
                        "Materia: Laboratorio de Programación Orientada a Objetos\n\n");

        try {
            ImageView icon = new ImageView(new Image(
                    getClass().getResourceAsStream("recursos_Ibarra/info.png")
            ));
            icon.setFitHeight(48);
            icon.setFitWidth(48);
            alert.setGraphic(icon);
        } catch (Exception ignored) {}

        alert.getDialogPane().getStylesheets().add(
                getClass().getResource("estilos_2094647.css").toExternalForm());

        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        try {
            stage.getIcons().add(new Image(getClass().getResourceAsStream("recursos_Ibarra/info.png")));
        } catch (Exception e) {}//de mas

        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
