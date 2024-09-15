import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main() {
  runApp( TextField_5_demo());
}
class TextField_5_demo extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('Flutter TextField Example'),
        ),
        body: Padding(
          padding: const EdgeInsets.all(16.0),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              TextField(
                // Key: Identifier for the TextField
                key: Key('text_field_key'),

                // Controller: Manages the text being edited
                controller: TextEditingController(text: 'Initial Text'),

                // FocusNode: Controls the focus of the TextField
                focusNode: FocusNode(),

                // Decoration: Controls the visual styling
                decoration: InputDecoration(
                  icon: Icon(Icons.person), // Icon at the start of the TextField
                  labelText: 'Name', // Label displayed above the TextField
                  hintText: 'Enter your name', // Hint displayed inside the TextField
                  helperText: 'Your full name', // Helper text displayed below the TextField
                  errorText: null, // Error text displayed below the TextField (null means no error)
                  prefixIcon: Icon(Icons.account_circle), // Icon inside the TextField, before the input
                  suffixIcon: Icon(Icons.check_circle), // Icon inside the TextField, after the input
                  border: OutlineInputBorder(), // Border style of the TextField
                ),

                // Text Input Configuration
                keyboardType: TextInputType.text, // Keyboard type (e.g., text, number, email)
                textInputAction: TextInputAction.done, // Action button on the keyboard
                textCapitalization: TextCapitalization.words, // Capitalization of the first letter of each word
                style: TextStyle(fontSize: 18.0, color: Colors.black), // Text style
                textAlign: TextAlign.left, // Text alignment
                textDirection: TextDirection.ltr, // Text direction (left-to-right)
                readOnly: false, // Whether the TextField is read-only
                showCursor: true, // Whether to show the cursor
                autofocus: false, // Whether to focus this TextField automatically
                obscureText: false, // Whether to obscure the text (for passwords)
                autocorrect: true, // Whether to enable autocorrect
                maxLines: 1, // Maximum number of lines (set to null for unlimited)
                maxLength: 20, // Maximum length of the input
                maxLengthEnforcement: MaxLengthEnforcement.enforced, // Enforces the max length
                onChanged: (value) {
                  print('Text changed: $value');
                }, // Called when the text changes
                onSubmitted: (value) {
                  print('Text submitted: $value');
                }, // Called when the user submits the text
                onEditingComplete: () {
                  print('Editing completed');
                }, // Called when editing is complete

                // Cursor Configuration
                cursorColor: Colors.blue, // Color of the cursor
                cursorWidth: 2.0, // Width of the cursor
                cursorHeight: 24.0, // Height of the cursor
                cursorRadius: Radius.circular(2.0), // Radius of the cursor

                // Scroll Configuration
                scrollPadding: EdgeInsets.all(20.0), // Padding when the keyboard appears
                scrollPhysics: BouncingScrollPhysics(), // Scroll physics for the TextField

                // Enables various input actions
                enableInteractiveSelection: true, // Enables text selection
                selectionControls: materialTextSelectionControls, // Selection controls (cut, copy, paste)
                toolbarOptions: ToolbarOptions(
                  copy: true,
                  cut: true,
                  paste: true,
                  selectAll: true,
                ), // Options for the selection toolbar
                enableSuggestions: true, // Enables suggestions

                // Input Formatter
                inputFormatters: [], // List of input formatters for the text

                // Configuration for IOS
                smartDashesType: SmartDashesType.enabled, // Enables smart dashes
                smartQuotesType: SmartQuotesType.enabled, // Enables smart quotes
                enableIMEPersonalizedLearning: true, // Enables personalized learning for the keyboard

                // Configuration for Decoration
                buildCounter: (
                    BuildContext context, {
                      required int currentLength,
                      required bool isFocused,
                      required int? maxLength,
                    }) {
                  return Text(
                    '$currentLength/$maxLength',
                    style: TextStyle(color: Colors.blue),
                  );
                }, // Custom counter for the input length
              ),
            ],
          ),
        ),
      ),
    );
  }
}