import classes from './Button.module.scss';

export function Button(props: ButtonProps) {
  
  const { text, onClick, ...rest } = props;

  return (
    <button onClick={onClick} className={classes.button} {...rest}>
      {text}
    </button>
  )
}

type ButtonProps = React.ButtonHTMLAttributes<HTMLButtonElement> & {
  text: string
}
